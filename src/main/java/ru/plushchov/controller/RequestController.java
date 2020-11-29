package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;
import ru.plushchov.service.REST.RequestService;

import java.util.UUID;

/**
 * Контроллер для обработки GET запросов
 */
@RestController
@RequestMapping("/api/request")
public class RequestController {
    private static final Logger logger = LogManager.getLogger(RequestController.class.getName());

    private RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    @RequestMapping("/ingredient")
    public IngredientDto ingredientRequestById(@RequestParam UUID id) {


        return requestService.reqIngredient(id);
    }

    @ModelAttribute
    /*Связывает конкретный эллемент с конкретной сущностью*/
    public IngredientDto ingredientDto() {

        return new IngredientDto();
    }

    @GetMapping
    @RequestMapping("/beverage")
    public BeverageDto beverageRequestById(@RequestParam UUID id) {


        return requestService.reqBeverage(id);
    }

    @ModelAttribute
    /*Связывает конкретный эллемент с конкретной сущностью*/
    public BeverageDto beverageDto() {

        return new BeverageDto();
    }

    @GetMapping
    @RequestMapping("/equipment")
    public EquipmentDto equipmentRequestById(@RequestParam UUID id) {


        return requestService.reqEquipment(id);
    }

    @ModelAttribute
    /*Связывает конкретный эллемент с конкретной сущностью*/
    public EquipmentDto equipmentDto() {

        return new EquipmentDto();
    }
}
