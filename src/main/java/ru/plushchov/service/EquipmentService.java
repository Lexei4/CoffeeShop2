package ru.plushchov.service;

import ru.plushchov.controller.dto.EquipmentDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Equipment
 */
public interface EquipmentService {

    /**
     * добавляет оборудование  в DAO
     * @param equipmentDto - DTO оборудования
     * @return EquipmentDto с проставленным id
     */
    EquipmentDto addEquipment(EquipmentDto equipmentDto);

    /**
     * удаляет объект из DAO
     * @param uuid - id оборудования для удаления
     * @return String - оборудование удалена
     */
    String deleteEquipment(UUID uuid);

    /**
     *  обновляет оборудование в ДАО
     * @param equipmentDto - DTO оборудование
     * @param id - id оборудование
     * @return EquipmentDto - DTO обновленного объекта
     */
    EquipmentDto updateEquipment(EquipmentDto equipmentDto, UUID id);

    /**
     * Получает DTO оборудования из DAO
     * @param id - id оборудования
     * @return EquipmentDto по данному UUID
     */
    EquipmentDto readEquipment(UUID id);
}
