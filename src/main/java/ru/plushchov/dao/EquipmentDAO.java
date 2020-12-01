package ru.plushchov.dao;

import ru.plushchov.model.Equipment;

import java.util.UUID;

/**
 * Интерфейс для работы с DAO класса Equipment
 */
public interface EquipmentDAO extends GenericDAO<Equipment, UUID>{
    /**
     *
     * @param name - наименование оборудования
     * @return boolean - возвращает true, если находит оборудование и flase - если нет
     *
     * проверяет находится ли данное оборудование в DAO
     */
    boolean equipmentExist(String name);

    /**
     *
     * @param id - id оборудования
     * @return  в случае успеха создает новый DAO объект по данному id
     *
     * Осуществляет поиск оборудования по id
     */
    Equipment findEquipmentById(UUID id);

    /**
     *
     * @param name
     * @return в случае успеха создает новый DAO объект по данному имени
     *
     * Осуществляет поиск оборудования по имени
     */
    Equipment findEquipmentByName(String name);
}

