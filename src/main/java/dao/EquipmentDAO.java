package dao;

import model.Equipment;

import java.util.UUID;

public interface EquipmentDAO extends GenericDAO<Equipment, UUID>{

    boolean equipmentExist(String username);

    Equipment findEquipmentById(String id);

    Equipment findEquipmentByName(String name);

}
