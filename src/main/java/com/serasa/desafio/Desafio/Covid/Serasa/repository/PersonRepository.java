package com.serasa.desafio.Desafio.Covid.Serasa.repository;

import com.serasa.desafio.Desafio.Covid.Serasa.model.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends MongoRepository<Person, Long> {

}