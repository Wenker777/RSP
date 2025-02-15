package com.example.springweb;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
    // CrudRepository предоставляет методы для работы с БД
}
