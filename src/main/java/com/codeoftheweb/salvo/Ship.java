package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String ship_type;

    @ElementCollection
    @Column(name="email")
    private List<String> ship_location = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="GamePlayer_id")
    private GamePlayer gamePlayer;

    public Ship() {};

    public long getId() {
        return id;
    };

    public void setLocation(List ship_location) {
        this.ship_location = ship_location;
    };

    public List getLocation() {
        return ship_location;
    }

    public void setType(String ship_type) {
        this.ship_type = ship_type;
    };

    public String getType() {
        return ship_type;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    }



