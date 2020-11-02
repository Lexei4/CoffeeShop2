package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;
import ru.plushchov.service.UpdateService;

@RestController
@RequestMapping("/api/update")
public class UpdateController {
    private static final Logger logger = LogManager.getLogger(UpdateController.class.getName());

    private UpdateService updateService;

    @Autowired
    public UpdateController(UpdateService updateService) {
        this.updateService = updateService;
    }

    @PutMapping
    @RequestMapping("/ingredient")
    public String ingredientUpdate(@RequestBody IngredientDto ingredientDto, BindingResult result) {

        if (result.hasErrors()) {
            ingredientDto.setErrors(result.getAllErrors());

            return ingredientDto.getErrors().toString();
        }


        return updateService.updateIngredient(ingredientDto);
    }

    @ModelAttribute
    /**Связывает конкретный эллемент с конкретной сущностью*/
    public IngredientDto ingredientDto() {

        return new IngredientDto();
    }

    @PutMapping
    @RequestMapping("/beverage")
    public BeverageDto beverageUpdate(@RequestBody BeverageDto beverageDto, BindingResult result) {

        if (result.hasErrors()) {
            beverageDto.setErrors(result.getAllErrors());
            return beverageDto;
        }

        updateService.updateBeverage(beverageDto);
        return beverageDto;
    }

    @ModelAttribute
    /**Связывает конкретный эллемент с конкретной сущностью*/
    public BeverageDto beverageDto() {

        return new BeverageDto();
    }

    @PutMapping
    @RequestMapping("/equipment")
    public EquipmentDto equipmentUpdate(@RequestBody EquipmentDto equipmentDto, BindingResult result) {

        if (result.hasErrors()) {
            equipmentDto.setErrors(result.getAllErrors());
            return equipmentDto;
        }

        updateService.updateEquipment(equipmentDto);
        return equipmentDto;
    }

    @ModelAttribute
    /**Связывает конкретный эллемент с конкретной сущностью*/
    public EquipmentDto equipmentDto() {

        return new EquipmentDto();
    }

}
