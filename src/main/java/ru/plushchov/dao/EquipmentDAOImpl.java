package ru.plushchov.dao;

import org.springframework.stereotype.Repository;
import ru.plushchov.model.Equipment;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class EquipmentDAOImpl extends AbstractDao<Equipment, UUID> implements EquipmentDAO {

    public EquipmentDAOImpl() {
        super(Equipment.class, new HashMap<>());
    }

    public boolean equipmentExist(String name){
        for (Equipment el : elements.values()) {
            if (el.getName().equals(name)) {
                return true;
            }
        }
        return false;
    };

    public Equipment findEquipmentById(UUID id){
        Equipment equipment = new Equipment();

        for (Equipment el : elements.values()) {
            if (el.getId().equals(id)) {
                equipment.setId(el.getId());
                equipment.setName(el.getName());
            }
        }
        return equipment;
    };

    public Equipment findEquipmentByName(String name){
        for (Equipment el : elements.values()) {
            if (el.getName().equals(name)) {
                return el;
            }
        }
        return null;
    };
}