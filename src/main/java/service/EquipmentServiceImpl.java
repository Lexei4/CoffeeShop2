package service;

import dao.EquipmentDAO;
import model.Equipment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EquipmentServiceImpl implements  EquipmentService{
    private static final Logger log = LogManager.getLogger(EquipmentServiceImpl.class.getName());

    private EquipmentDAO equipmentDAO;

    public EquipmentServiceImpl(EquipmentDAO equipmentDAO) {
        log.info("createService");
        this.equipmentDAO = equipmentDAO;
    }

    @Override
    public void addEquipment(Equipment equipment) {
        equipmentDAO.save(equipment);
    }

    @Override
    public void deleteEquipment(Equipment equipment) {
        equipmentDAO.delete(equipment);
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        equipmentDAO.update(equipment);
    }
}
