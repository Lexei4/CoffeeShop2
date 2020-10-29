package ru.plushchov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api")
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", "Hello, World");
        List<String> strings = Arrays.asList("tra -tra", "la la", "га га");
        model.addAttribute("strings", strings);
        return "hello";
    }

    @RequestMapping("/hello2")
    public String sayHello2(Model model) {
        model.addAttribute("message", "Hello, World");
        List<String> strings = Arrays.asList("tra -tra", "la la", "га га");
        model.addAttribute("strings", strings);
        return "hello";
    }

}