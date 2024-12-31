package com.example.demo; // Укажите правильный пакет вашего проекта

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.controller..*(..))") // Указываем точку среза для контроллеров
    public Object logRequestResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Calling method: " + joinPoint.getSignature().getName());
        Object returnValue = joinPoint.proceed();
        logger.info("Method executed: " + joinPoint.getSignature().getName() + ", Returned value: " + returnValue);
        return returnValue;
    }
}
