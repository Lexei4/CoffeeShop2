package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.plushchov.service.REST.DeleteService;

@RestController
@RequestMapping("/api/beverage")
public class BeverageController {
    private static final Logger log = LogManager.getLogger(BeverageController.class.getName());

    private DeleteService deleteService;

}
