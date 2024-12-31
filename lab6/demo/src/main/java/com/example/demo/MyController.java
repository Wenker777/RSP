package com.example.demo;

import com.example.demo.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/test")
    public String testMethod() {
        myService.someMethod();  // Вызов метода из сервиса
        return "Method executed!";
    }
}
