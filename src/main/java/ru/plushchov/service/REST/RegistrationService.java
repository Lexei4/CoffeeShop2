package ru.plushchov.service.REST;

import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;

/**
 Интерфейс для обработки POST запросов DTO
 * */
public interface RegistrationService {

    /**
     *
     * @param ingredientDto - DTO ингредиента для регистрации
     * @return
     */
    IngredientDto regIngredient(IngredientDto ingredientDto);

    /**
     *
     * @param beverageDto  DTO напитка для регистрации
     * @return
     */
    BeverageDto regBeverage(BeverageDto beverageDto);

    /**
     *
     * @param equipmentDto DTO оборудования для регистрации
     * @return
     */
    EquipmentDto regEquipment(EquipmentDto equipmentDto);

}
