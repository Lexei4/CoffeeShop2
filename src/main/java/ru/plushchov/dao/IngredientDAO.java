package ru.plushchov.dao;

import ru.plushchov.model.Ingredient;

import java.util.UUID;

/**
 * Интерфейс для работы с DAO класса Beverage
 */
public interface IngredientDAO extends GenericDAO<Ingredient, UUID>{

    /**
     *
     * @param username
     * @return
     *
     * проверяет находится ли данный ингредиент в DAO
     */
    boolean ingredientExist(String username);

    /**
     *
     * @param id
     * @return
     * Осуществляет поиск ингредиента по id
     */
    Ingredient findIngredientById(UUID id);

    /**
     *
     * @param name
     * @return
     *
     * Осуществляет поиск ингредиента по имени
     */
    Ingredient findIngredientByName(String name);

}
