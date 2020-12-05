package ru.plushchov.service;

import ru.plushchov.controller.dto.BeverageDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Beverage
 */
public interface BeverageService {
    /**
     *
     * @param beverageDto - объект напиток
     * добавляет напиток  в DAO
     */
    BeverageDto addBeverage(BeverageDto beverageDto);

    /**
     *
     * @param id - объект напиток
     * удаляет напиток из  DAO
     */
    String deleteBeverage(UUID id);

    /**
     *
     * @param beverageDto -  объект напиток
     * обновляет напиток в ДАО
     */
    String updateBeverage(BeverageDto beverageDto);

    BeverageDto readBeverage(UUID uuid);
}
