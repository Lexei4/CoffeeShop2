package ru.plushchov.service;

import ru.plushchov.model.Beverage;

/**
 * Интерфейс для работы с бизнес-логикой класса Beverage
 */
public interface BeverageService {
    /**
     *
     * @param beverage
     * добавляет напиток  в DAO
     */
    void addBeverage(Beverage beverage);

    /**
     *
     * @param beverage
     * удаляет напиток из  DAO
     */
    void deleteBeverage(Beverage beverage);

    /**
     *
     * @param beverage
     * обновляет напиток в ДАО
     */
    void updateBeverage(Beverage beverage);
}
