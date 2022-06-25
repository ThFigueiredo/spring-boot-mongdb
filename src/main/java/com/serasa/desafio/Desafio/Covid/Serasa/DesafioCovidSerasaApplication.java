package com.serasa.desafio.Desafio.Covid.Serasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class DesafioCovidSerasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioCovidSerasaApplication.class, args);
	}

}
