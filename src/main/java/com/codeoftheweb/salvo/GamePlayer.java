package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Date joinedDate;
    private Date gamePlayerCreationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player player;

    @OneToMany(mappedBy="gamePlayer", fetch=FetchType.EAGER)
    Set<Ship> ships = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game game;

    public GamePlayer() { }

    public GamePlayer(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    public long getId() {
        return id;
    }

    public void setPlayer(Player player) {
        this.player=player;
    }

    public Player getPlayers() {
        return player;
    }

    public void setGame(Game game) {
        this.game=game;
    }

    public Game getGames() {
        return game;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public void addShip(Ship ship) {
        ship.setGamePlayer(this);
        ships.add(ship);
    }





}