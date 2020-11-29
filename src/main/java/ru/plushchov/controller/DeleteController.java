package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.plushchov.service.REST.DeleteService;

import java.util.UUID;

/**
 * Контроллер для обработки Delete запросов
 */
@RestController
@RequestMapping("/api/delete")
public class DeleteController {
    private static final Logger logger = LogManager.getLogger(DeleteController.class.getName());

    private DeleteService deleteService;

    @Autowired
    public DeleteController(DeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @DeleteMapping
    @RequestMapping("/ingredient")
    public String ingredientDeleteById(@RequestParam UUID id) {

        return deleteService.deleteIngredient(id);

    }

    @DeleteMapping
    @RequestMapping("/beverage")
    public String beverageDeleteById(@RequestParam UUID id) {

        return deleteService.deleteBeverage(id);

    }

    @DeleteMapping
    @RequestMapping("/equipment")
    public String equipmentDeleteById(@RequestParam UUID id) {

        return deleteService.deleteEquipment(id);

    }


}
