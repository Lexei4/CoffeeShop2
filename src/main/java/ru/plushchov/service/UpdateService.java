package ru.plushchov.service;

import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;

/**
 Интерфейс для обработки PUT запросов DTO
 * */
public interface UpdateService {
    String  updateIngredient(IngredientDto ingredientDto);

    String updateBeverage(BeverageDto beverageDto);

    String updateEquipment(EquipmentDto equipmentDto);
}
