package ru.plushchov.dao;

import ru.plushchov.model.Beverage;

import java.util.UUID;

/**
 * Интерфейс для работы с DAO класса Beverage
 */
public interface BeverageDAO  extends GenericDAO<Beverage, UUID>{

    /**
     *
     * @param id
     * @return
     * Осуществляет поиск напитка по id
     */
    Beverage findBeverageById(UUID id);



    /**
     *
     * @param name
     * @return
     * Осуществляет поиск ингредиента по типу
     */
    Beverage findBeverageByType(String name);
}
