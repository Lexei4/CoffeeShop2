package service;

import model.Equipment;

public interface EquipmentService {
    void addEquipment(Equipment equipment);
    void deleteEquipment(Equipment equipment);
    void updateEquipment(Equipment equipment);
}