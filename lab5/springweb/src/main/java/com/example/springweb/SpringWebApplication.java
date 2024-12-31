package com.example.springweb;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringWebApplication {

    @Autowired
    private TeamRepository teamRepository; // Внедрение зависимости

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
    }

    @PostConstruct // Метод вызывается после инициализации приложения
    public void init() {
        List<Team> list = new ArrayList<>();

        // Создание игроков для первой команды
        Set<Player> playersForDinamo = new HashSet<>();
        playersForDinamo.add(new Player("Anton Shunin", "GK"));
        playersForDinamo.add(new Player("Eli Dasa", "Defender"));
        playersForDinamo.add(new Player("Vyacheslav Grulyov", "FW"));

        // Создание первой команды с игроками
        Team dinamo = new Team("Moscow", "Dinamo", playersForDinamo);
        list.add(dinamo);

        // Создание второй команды (без игроков)
        Team cska = new Team("Moscow", "CSKA", null);
        list.add(cska);

        // Сохраняем данные в базу данных
        teamRepository.saveAll(list);
    }
}
