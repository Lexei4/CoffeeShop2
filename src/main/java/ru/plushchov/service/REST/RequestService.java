package ru.plushchov.service.REST;

import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;

import java.util.UUID;

/**
 Интерфейс для обработки GET запросов DTO
 * */

public interface RequestService {
    /**
     *
     * @param uuid - uuid игредиента для GET-запроса
     * @return
     */
    IngredientDto reqIngredient(UUID uuid);
    /**
     *
     * @param uuid - uuid напитка для GET-запроса
     * @return
     */
    BeverageDto reqBeverage(UUID uuid);
    /**
     *
     * @param uuid - uuid оборудования для GET-запроса
     * @return
     */
    EquipmentDto reqEquipment(UUID uuid);
}
