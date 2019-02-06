package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String userName;

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;

    public Player() { }
    public Player(String name) {
        userName = name;
    }

    public Player getPlayers(Player player) {
        return player;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String toString() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public void addGamePlayers(GamePlayer gamePlayer) {
        gamePlayer.setPlayer(this);
        this.gamePlayers.add(gamePlayer);
    }

}