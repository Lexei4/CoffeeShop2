package ru.plushchov.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value = "/first")
//    @GetMapping(value = "/first"")
    public String getIndex() {
        return "first";
    }
}
