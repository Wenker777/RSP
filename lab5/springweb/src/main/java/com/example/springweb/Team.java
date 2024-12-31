package com.example.springweb;

import jakarta.persistence.*;
import java.util.Set;

@Entity // Указывает, что это сущность JPA
public class Team {
    @Id // Указывает первичный ключ
    @GeneratedValue // Генерирует значение для идентификатора автоматически
    private Long id;

    private String name;
    private String location;
    private String mascot;

    @OneToMany(cascade = CascadeType.ALL) // Связь один-ко-многим
    @JoinColumn(name = "team_id") // Внешний ключ
    private Set<Player> players;

    // Конструкторы
    public Team() {}

    public Team(String location, String name, Set<Player> players) {
        this.location = location;
        this.name = name;
        this.players = players;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
