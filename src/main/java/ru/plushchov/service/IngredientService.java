package ru.plushchov.service;

import ru.plushchov.controller.dto.IngredientDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Ingredient
 */
public interface IngredientService {

    /**
     * добавляет ингредиент в DAO
     * @param ingredientDto - DTO ингредиента
     * @return  IngredientDto с проставленным id
     */
    IngredientDto addIngredient(IngredientDto ingredientDto);

    /**
     * удаляет ингредиент из  DAO
     * @param uuid - id оборудования для удаления
     * @return String ингредиент удален
     */
    String deleteIngredient(UUID uuid);

    /**
     * обновляет ингредиент в ДАО
     * @param ingredientDto - DTO ингредиента
     * @param id - id ингредиента
     * @return IngredientDto - DTO обновленного объекта
     */
    IngredientDto updateIngredient(IngredientDto ingredientDto, UUID id);

    /**
     * читает ингредиент из DAO
     *
     * @param uuid - id ингредиента
     * @return IngredientDto по данному UUID
     */
    IngredientDto readIngredient(UUID uuid);
}

