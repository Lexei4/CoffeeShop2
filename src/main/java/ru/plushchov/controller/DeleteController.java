package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.plushchov.service.REST.DeleteService;

import java.util.UUID;

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
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/ingredient")
    public String ingredientDeleteById(@RequestParam UUID id) {

        return deleteService.deleteIngredient(id);

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/beverage")
    public String beverageDeleteById(@RequestParam UUID id) {

        return deleteService.deleteBeverage(id);

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/equipment")
    public String equipmentDeleteById(@RequestParam UUID id) {

        return deleteService.deleteEquipment(id);

    }


}
