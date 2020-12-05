package ru.plushchov.service;

import ru.plushchov.controller.dto.BeverageDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Beverage
 */
public interface BeverageService {
    /**
     *
     * @param beverageDto - DTO напитка
     * добавляет напиток  в DAO
     */
    BeverageDto addBeverage(BeverageDto beverageDto);

    /**
     *
     * @param id - id напиток
     * удаляет напиток из  DAO
     */
    String deleteBeverage(UUID id);

    /**
     *
     * @param beverageDto -  объект напиток
     * обновляет напиток в ДАО
     */
    String updateBeverage(BeverageDto beverageDto);

    /**
     * запрос напитка в БД
     * @param uuid - UUID напитка
     * @return
     */
    BeverageDto readBeverage(UUID uuid);
}
