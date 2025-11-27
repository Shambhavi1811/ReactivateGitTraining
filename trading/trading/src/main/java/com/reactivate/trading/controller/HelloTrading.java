package com.reactivate.trading.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class HelloTrading {

    @GetMapping("/hello")
    public String sayHello() {
        return "Welcome to Trading World!";
    }

// pathvariable
    @GetMapping("/hello/{name}")
    public String sayHelloToName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // request parameter
    @GetMapping("/greet1")
    public String greet1(@RequestParam String name) {
        return "Greetings, " + name + "!";
    }

    // optional parameter

    @GetMapping("/greet2")
    public String greet2(@RequestParam(defaultValue = "Friend") String name) {
        return "Greetings, " + name + "!";
    }

    //return multiple values
    @GetMapping("/info")
    public String getInfo(@RequestParam String name, @RequestParam int age) {
        return "Name: " + name + ", Age: " + age;
    }
}
