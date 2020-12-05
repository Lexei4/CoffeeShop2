package ru.plushchov.service;

import ru.plushchov.controller.dto.EquipmentDto;

import java.util.UUID;

/**
 * Интерфейс для работы с бизнес-логикой класса Equipment
 */
public interface EquipmentService {
    /**
     *
     * @param equipmentDto - объект оборудование
     * добавляет оборудование  в DAO
     */
    EquipmentDto addEquipment(EquipmentDto equipmentDto);

    /**
     *
     * @param uuid -
     */
    String deleteEquipment(UUID uuid);

    /**
     *
     * @param  - объект оборудование
     * обновляет оборудование в ДАО
     */
    String updateEquipment(EquipmentDto equipmentDto);

    EquipmentDto readEquipment(UUID id);
}
