package com.serasa.desafio.Desafio.Covid.Serasa.repository;

import com.serasa.desafio.Desafio.Covid.Serasa.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}
