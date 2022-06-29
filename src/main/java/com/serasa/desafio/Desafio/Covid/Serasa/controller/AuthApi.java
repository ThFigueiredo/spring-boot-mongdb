package com.serasa.desafio.Desafio.Covid.Serasa.controller;

import com.serasa.desafio.Desafio.Covid.Serasa.model.User;
import com.serasa.desafio.Desafio.Covid.Serasa.config.AuthBody;
import com.serasa.desafio.Desafio.Covid.Serasa.config.Register;
import com.serasa.desafio.Desafio.Covid.Serasa.config.Roles;
import com.serasa.desafio.Desafio.Covid.Serasa.repository.UserRepository;
import com.serasa.desafio.Desafio.Covid.Serasa.secure.JwtTokenProvider;
import com.serasa.desafio.Desafio.Covid.Serasa.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/auth")
public class AuthApi {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @Autowired
    private CustomUserDetailsService userService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthBody data) {
        try {
            String username = data.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, this.users.findByEmail(username).getRoles());
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Inválido email/password");
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Register register, @RequestParam Roles role) {
        User userExists = userService.findUserByEmail(register.getEmail());
        if (userExists != null) {
            throw new BadCredentialsException("Usuário com o nome: " + register.getEmail() + " já existe");
        }

        User user = new User();
        user.setEmail(register.getEmail());
        user.setFullname(register.getName());
        user.setPassword(register.getPassword());
        userService.saveUser(user, role.name());
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "Usuário cadastrado com sucesso");
        return ok(model);
    }
}
