package com.example.springpostgres;

import com.example.springpostgres.models.ApplicationMeta;
import com.example.springpostgres.repositories.ApplicationMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.springpostgres.controllers, " +
		"com.example.springpostgres.models, com.example.springpostgres.repositories")
public class SpringPostGresDemoApplication implements CommandLineRunner {

	@Autowired
	ApplicationMetaRepository applicationMetaRepository;

	@Override
	public void run(String... args)  {
		// Create a new ApplicationMeta on server start up
		ApplicationMeta data = new ApplicationMeta();
		data.setDescription("This is Spring Postgres Integration Demp on CF");
		data.setName("CFSpringPostgreSQLApp");
		applicationMetaRepository.save(data);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringPostGresDemoApplication.class, args);
	}



}
