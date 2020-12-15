package ru.plushchov.service;

import ru.plushchov.controller.dto.EquipmentDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Equipment
 */
public interface EquipmentService {
    /**
     * @param equipmentDto - DTO оборудования
     *                     добавляет оборудование  в DAO
     */
    EquipmentDto addEquipment(EquipmentDto equipmentDto);

    /**
     * удаляет объект из DAO
     *
     * @param uuid - id оборудования для удаления
     */
    String deleteEquipment(UUID uuid);

    /**
     * @param - объект оборудование
     *          обновляет оборудование в ДАО
     */
    EquipmentDto updateEquipment(EquipmentDto equipmentDto, UUID id);

    /**
     * Получает DTO оборудования из DAO
     *
     * @param id - id оборудования
     * @return
     */
    EquipmentDto readEquipment(UUID id);
}
