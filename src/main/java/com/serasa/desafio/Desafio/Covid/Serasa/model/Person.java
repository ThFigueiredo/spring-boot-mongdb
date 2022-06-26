package com.serasa.desafio.Desafio.Covid.Serasa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.UUID;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Person")
public class Person {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;
    @Email
    private String email;
    @CPF
    private String cpf;
    private Boolean isVaccinated;

}