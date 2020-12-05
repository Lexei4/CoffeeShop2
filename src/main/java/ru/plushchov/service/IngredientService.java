package ru.plushchov.service;

import ru.plushchov.controller.dto.IngredientDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Ingredient
 */
public interface IngredientService {
    /**
     * добавляет ингредиент в DAO
     * @param ingredientDto - DTO ингредиентf
     */
    IngredientDto addIngredient(IngredientDto ingredientDto);

    /**
     *
     * @param uuid  - uuid объекта ингредиент на удаление
     * удаляет ингредиент из  DAO
     */
    String deleteIngredient(UUID uuid);

    /***
     *
     * @param ingredientDto  - DTO ингредиента
     * обновляет ингредиент в ДАО
     */
    String updateIngredient(IngredientDto ingredientDto);

    IngredientDto readIngredient(UUID uuid);
}

