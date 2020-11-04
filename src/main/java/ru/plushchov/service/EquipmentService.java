package ru.plushchov.service;

import ru.plushchov.model.Equipment;

/**
 * Интерфейс для работы с бизнес-логикой класса Equipment
 */
public interface EquipmentService {
    /**
     *
     * @param equipment
     * добавляет оборудование  в DAO
     */
    void addEquipment(Equipment equipment);

    /**
     *
     * @param equipment
     * удаляет оборудование из  DAO
     */
    void deleteEquipment(Equipment equipment);

    /**
     *
     * @param equipment
     * обновляет оборудование в ДАО
     */
    void updateEquipment(Equipment equipment);
}
