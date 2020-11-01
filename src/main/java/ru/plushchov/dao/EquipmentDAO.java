package ru.plushchov.dao;

import ru.plushchov.model.Equipment;

import java.util.UUID;

public interface EquipmentDAO extends GenericDAO<Equipment, UUID>{

    boolean equipmentExist(String username);

    Equipment findEquipmentById(UUID id);

    Equipment findEquipmentByName(String name);

}

