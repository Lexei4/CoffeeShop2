package ru.plushchov.service.REST;

import java.util.UUID;

/**
 Интерфейс для обработки DELETE запросов DTO
 * */
public interface DeleteService {
    /**
     *
     * @param uuid - uuid ингредиента на удаление
     * @return
     */
    String deleteIngredient(UUID uuid);

    /**
     *
     * @param uuid - uuid напитка для удаления
     * @return
     */
    String deleteBeverage(UUID uuid);

    /**
     *
     * @param uuid - uuid оборудования для удаления
     * @return
     */
    String deleteEquipment(UUID uuid);
}
