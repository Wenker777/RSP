package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private static final Logger verboseLogger = LoggerFactory.getLogger("VERBOSE_LOGGER");

    @Timed // Аннотация для логирования времени выполнения метода
    public void someMethod() {
        verboseLogger.trace("Очень подробное сообщение");

        // Ваш код обработки
        try {
            Thread.sleep(2000); // Пример задержки (2 секунды)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
