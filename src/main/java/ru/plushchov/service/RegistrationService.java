package ru.plushchov.service;

import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;

public interface RegistrationService {

    IngredientDto regIngredient(IngredientDto ingredientDto);

    BeverageDto regBeverage(BeverageDto beverageDto);

    EquipmentDto regEquipment(EquipmentDto equipmentDto);

}
