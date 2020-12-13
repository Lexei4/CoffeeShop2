package ru.plushchov.service;

import ru.plushchov.controller.dto.BeverageDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Beverage
 */
public interface BeverageService {
    /**
     * @param beverageDto - DTO напитка
     *                    добавляет напиток  в DAO
     */
    BeverageDto addBeverage(BeverageDto beverageDto);

    /**
     * @param id - id напиток
     *           удаляет напиток из  DAO
     */
    String deleteBeverage(UUID id);

    /**
     * обновляет напиток в ДАО
     * @param beverageDto - объект напиток
     * @param id - UUID напитка
     * @return
     */
    BeverageDto updateBeverage(BeverageDto beverageDto, UUID id);


    /**
     * запрос напитка в БД
     *
     * @param uuid - UUID напитка
     * @return
     */
    BeverageDto readBeverage(UUID uuid);
}
