package ru.plushchov.service.REST;

import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;

/**
 Интерфейс для обработки POST запросов DTO
 * */
public interface RegistrationService {

    IngredientDto regIngredient(IngredientDto ingredientDto);

    BeverageDto regBeverage(BeverageDto beverageDto);

    EquipmentDto regEquipment(EquipmentDto equipmentDto);

}
