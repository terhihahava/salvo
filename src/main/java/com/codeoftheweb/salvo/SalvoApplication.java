package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	;

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gameplayerRepository, ShipRepository shipRepository)  {
		return (args) -> {
			Player p1 = new Player("j.bauer@ctu.gov");
			Player p2 = new Player("c.obrian@ctu.gov ");
			Player p3 = new Player("kim_bauer@gmail.com ");
			playerRepository.save(p1);
			playerRepository.save(p2);
			playerRepository.save(p3);
			Game g1 = new Game(new Date());
			Game g2 = new Game(new Date());
			gameRepository.save(g1);
			gameRepository.save(g2);
			GamePlayer gp1 = new GamePlayer(p1, g1);
			GamePlayer gp2 = new GamePlayer(p2, g1);
			GamePlayer gp3 = new GamePlayer(p3, g2);
			gameplayerRepository.save(gp1);
			gameplayerRepository.save(gp2);
			gameplayerRepository.save(gp3);
			Player p4 = new Player("terhi.ahava@gmail.com ");
			playerRepository.save(p4);
			Game g3 = new Game(new Date());
			gameRepository.save(g3);
			GamePlayer gp4 = new GamePlayer(p4, g3);
			gameplayerRepository.save(gp4);

			List s1_location = new ArrayList<String>();
			s1_location.add("A1");
			Ship s1 = new Ship(s1_location, "Destroyer");
//			Ship s2 = new Ship("A5, A6, A7", "Submarine");
//			Ship s3 = new Ship("D2, E2, F2, G2", "Patrol Boat");
			shipRepository.save(s1);
//			shipRepository.save(s2);
//			shipRepository.save(s3);
			gp1.addShip(s1);


			};

	}
}
