package ru.plushchov.service;

import ru.plushchov.model.Ingredient;

/**
 * Интерфейс для работы с бизнес-логикой класса Ingredient
 */
public interface IngredientService {
    /**
     *
     * @param ingredient
     *
     * добавляет ингредиент в DAO
     */
    void addIngredient(Ingredient ingredient);

    /**
     *
     * @param ingredient
     * удаляет ингредиент из  DAO
     */
    void deleteIngredient(Ingredient ingredient);

    /***
     *
     * @param ingredient
     * обновляет ингредиент в ДАО
     */
    void updateIngredient(Ingredient ingredient);
}

