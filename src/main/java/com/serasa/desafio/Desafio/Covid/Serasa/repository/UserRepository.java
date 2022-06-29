package com.serasa.desafio.Desafio.Covid.Serasa.repository;

import com.serasa.desafio.Desafio.Covid.Serasa.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
