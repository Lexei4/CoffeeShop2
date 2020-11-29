package ru.plushchov.dao;

import ru.plushchov.model.Ingredient;

import java.util.UUID;

/**
 * Интерфейс для работы с DAO класса Beverage
 */
public interface IngredientDAO extends GenericDAO<Ingredient, UUID>{

    /**
     *
     * @param name - наименование ингредиента
     * @return boolean true - если ингредиент уже существует и false - если нет
     *
     * проверяет находится ли данный ингредиент в DAO
     */
    boolean ingredientExist(String name);

    /**
     *
     * @param id - id ингредиента
     * @return возращает новый DAO обхект с данным ID, в случае успеха
     * Осуществляет поиск ингредиента по id
     */
    Ingredient findIngredientById(UUID id);

    /**
     *
     * @param name - наименование оборудования
     * @return озращает новый DAO обхект с данным name, в случае успеха
     *
     * Осуществляет поиск ингредиента по имени
     */
    Ingredient findIngredientByName(String name);

}
