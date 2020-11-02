package ru.plushchov.service.REST;

import java.util.UUID;

/**
 Интерфейс для обработки DELETE запросов DTO
 * */
public interface DeleteService {
    String deleteIngredient(UUID uuid);

    String deleteBeverage(UUID uuid);

    String deleteEquipment(UUID uuid);
}
