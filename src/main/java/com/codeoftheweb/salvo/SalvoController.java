package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SalvoController {

    @Autowired
    private GameRepository gameRepo;

    @Autowired
    private GamePlayerRepository gamePlayerRepo;

//    @RequestMapping("api/games")
//    public List<Map<String, Object>> getAllGames() {
//        List<Map<String, Object>> result = new ArrayList<>();
//
//        gameRepo.findAll().forEach(game -> {
//
//            Map<String, Object> tempMap = new HashMap<>();
//            tempMap.put("gameId", game.getId());
//            tempMap.put("created", game.getCreationDate());
//            tempMap.put("gamePlayers", getListOfGamePlayers(game.getGamePlayers()));
//
//            result.add(tempMap);
//        });
//
//        return result;
//    }
//
//    private List<Map<String, Object>> getListOfGamePlayers(Set<GamePlayer> gamePlayers) {
//        List<Map<String, Object>> gamePlayersList = new ArrayList<>();
//        gamePlayers.forEach(gamePlayer -> {
//
//            Map<String, Object> result = new HashMap<>();
//            result.put("id", gamePlayer.getId());
//            result.put("player", getPlayerInfo(gamePlayer));
//
//            gamePlayersList.add(result);
//        });
//
//        return gamePlayersList;
//    }
//
//    private Map<String, Object> getPlayerInfo(GamePlayer gamePlayer) {
//        Map<String, Object> result = new HashMap<>();
//        result.put("id", gamePlayer.getPlayers().getId());
//        result.put("email", gamePlayer.getPlayers().getUserName());
//
//        return result;
//    }

    @RequestMapping(value="api/game-view/{gamePlayer_Id}", method= RequestMethod.GET)

    public List<Map<String, Object>> getGamePlayerById(@PathVariable Long gamePlayer_Id) {
    GamePlayer gamePlayer = gamePlayerRepo.findById(gamePlayer_Id);
    Game currentGame = gamePlayer.getGame();

    List<Map<String, Object>> result = new ArrayList<>();


        Map<String, Object> tempMap = new HashMap<>();
        tempMap.put("gameId", currentGame.getId());
        tempMap.put("created", currentGame.getCreationDate());
        tempMap.put("gamePlayers", getListOfGamePlayers(currentGame.gamePlayers));

        result.add(tempMap);


        return result;
    };

    private List<Map<String, Object>> getListOfGamePlayers(Set<GamePlayer> gamePlayers) {
        List<Map<String, Object>> gamePlayersList = new ArrayList<>();
        gamePlayers.forEach(gamePlayer -> {

            Map<String, Object> result = new HashMap<>();
            result.put("id", gamePlayer.getId());
            result.put("player", getPlayerInfo(gamePlayer));
            result.put("ships", getShipInfo(gamePlayer));
//            result.put("ships", gamePlayer.getShips());

            gamePlayersList.add(result);
        });

        return gamePlayersList;
    };

    private Map<String, Object> getPlayerInfo(GamePlayer gamePlayer) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", gamePlayer.getPlayers().getId());
        result.put("email", gamePlayer.getPlayers().getUserName());

        return result;
    };

    private List<Map<String, Object>> getShipInfo(GamePlayer gamePlayer) {
        List<Map<String, Object>> ShipsList = new ArrayList<>();

        gamePlayer.getShips().forEach(ship -> {

    Map<String, Object> result = new HashMap<>();
        result.put("location",ship.getLocation());
        result.put("type", ship.getType());

            ShipsList.add(result);});

        return ShipsList   ;}
    }
