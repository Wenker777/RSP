package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация для отслеживания времени выполнения метода
@Target(ElementType.METHOD) // Аннотация будет применяться к методам
@Retention(RetentionPolicy.RUNTIME) // Аннотация будет доступна во время выполнения
public @interface Timed {}
