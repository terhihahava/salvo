package com.codeoftheweb.salvo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static java.util.stream.Collectors.toList;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy="game", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;

    private Date creationDate = new Date();

    public Game() {};

    public Game(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationDate() {
        return creationDate.toString();
    }

    public long getId() {
        return id;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate; }

    public void addGamePlayers(GamePlayer gamePlayer) {
        gamePlayer.setGame(this);
        this.gamePlayers.add(gamePlayer);}

    public Set<GamePlayer> getGamePlayers() {
        return this.gamePlayers;

    }

}
