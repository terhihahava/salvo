package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	;

	@Bean
	public CommandLineRunner initData(PlayerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Player("terhi.ahava@gmail.com"));
			repository.save(new Player("j.bauer@ctu.gov"));
			repository.save(new Player("c.obrian@ctu.gov"));
		};

	}
}
