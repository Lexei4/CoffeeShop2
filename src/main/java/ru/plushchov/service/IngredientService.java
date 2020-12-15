package ru.plushchov.service;

import ru.plushchov.controller.dto.IngredientDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Ingredient
 */
public interface IngredientService {
    /**
     * добавляет ингредиент в DAO
     *
     * @param ingredientDto - DTO ингредиента
     */
    IngredientDto addIngredient(IngredientDto ingredientDto);

    /**
     * @param uuid - uuid объекта ингредиент на удаление
     *             удаляет ингредиент из  DAO
     */
    String deleteIngredient(UUID uuid);

    /**
     * обновляет ингредиент в ДАО
     * @param ingredientDto - DTO ингредиента
     * @param id - id ингредиента
     * @return
     */
    IngredientDto updateIngredient(IngredientDto ingredientDto, UUID id);

    /**
     * читает ингредиент из DAO
     *
     * @param uuid - id ингредиента
     * @return
     */
    IngredientDto readIngredient(UUID uuid);
}

