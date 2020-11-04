package ru.plushchov.dao;

import ru.plushchov.model.Equipment;

import java.util.UUID;

/**
 * Интерфейс для работы с DAO класса Equipment
 */
public interface EquipmentDAO extends GenericDAO<Equipment, UUID>{

    /**
     *
     * @param username
     * @return
     *
     * проверяет находится ли данное оборудование в DAO
     */
    boolean equipmentExist(String username);

    /**
     *
     * @param id
     * @return
     *
     * Осуществляет поиск оборудования по id
     */
    Equipment findEquipmentById(UUID id);

    /**
     *
     * @param name
     * @return
     *
     * Осуществляет поиск оборудования по имени
     */
    Equipment findEquipmentByName(String name);

}

