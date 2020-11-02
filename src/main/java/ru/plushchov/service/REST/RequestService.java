package ru.plushchov.service.REST;

import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;

import java.util.UUID;

/**
 Интерфейс для обработки GET запросов DTO
 * */

public interface RequestService {
    IngredientDto reqIngredient(UUID uuid);

    BeverageDto reqBeverage(UUID uuid);

    EquipmentDto reqEquipment(UUID uuid);
}
