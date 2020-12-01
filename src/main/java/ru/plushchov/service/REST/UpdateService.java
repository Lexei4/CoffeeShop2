package ru.plushchov.service.REST;

import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;

/**
 Интерфейс для обработки PUT запросов DTO
 * */
public interface UpdateService {
    /**
     *
     * @param ingredientDto - DTO ингредиента для запроса на обовление
     * @return
     */
    String  updateIngredient(IngredientDto ingredientDto);

    /**
     *
     * @param beverageDto - DTO напитка для запроса на обовление
     * @return
     */
    String updateBeverage(BeverageDto beverageDto);

    /**
     *
     * @param equipmentDto - DTO оборудования для запроса на обовление
     * @return
     */
    String updateEquipment(EquipmentDto equipmentDto);
}
