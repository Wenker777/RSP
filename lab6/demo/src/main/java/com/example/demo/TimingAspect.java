package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component // Указываем, что этот класс является аспектом
public class TimingAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimingAspect.class);

    @Around("@annotation(com.example.demo.Timed)") // Перехватываем методы с аннотацией @Timed
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis(); // Начало выполнения метода
        Object proceed = joinPoint.proceed(); // Выполнение метода
        long executionTime = System.currentTimeMillis() - start; // Время выполнения

        // Логирование времени выполнения метода
        logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed; // Возвращаем результат метода
    }
}
