package ru.plushchov.service;

import ru.plushchov.controller.dto.BeverageDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Beverage
 */
public interface BeverageService {

    /**
     * добавляет напиток  в DAO
     * @param beverageDto - DTO напитка
     * @return beverageDto с проставленным id
     */
    BeverageDto addBeverage(BeverageDto beverageDto);

    /**
     *  удаляет напиток из  DAO
     * @param id - id напиток
     * @return String - напиток удален
     */
    String deleteBeverage(UUID id);

    /**
     * обновляет напиток в ДАО
     * @param beverageDto - объект напиток
     * @param id - UUID напитка
     * @return BeverageDto - обновленный Dto
     */
    BeverageDto updateBeverage(BeverageDto beverageDto, UUID id);

    /**
     * запрос напитка в БД
     * @param uuid - UUID напитка
     * @return BeverageDto по данному UUID
     */
    BeverageDto readBeverage(UUID uuid);
}
