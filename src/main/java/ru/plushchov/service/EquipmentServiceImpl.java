package ru.plushchov.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.dao.EquipmentDAO;
import ru.plushchov.model.Equipment;

import java.util.UUID;

@Service
public class EquipmentServiceImpl implements  EquipmentService{
    private static final Logger log = LogManager.getLogger(EquipmentServiceImpl.class.getName());
    private EquipmentDAO equipmentDAO;

    public EquipmentServiceImpl(EquipmentDAO equipmentDAO) {
        log.info("createService");
        this.equipmentDAO = equipmentDAO;
    }

    @Override
    public EquipmentDto addEquipment(EquipmentDto equipmentDto) {
        Equipment equipment = new Equipment(
                UUID.randomUUID(), equipmentDto.getEquipmentName()
        );

        equipmentDAO.save(equipment);
        equipmentDto.setId(equipment.getId());

        return equipmentDto;
    }

    @Override
    public String deleteEquipment(UUID uuid) {
        equipmentDAO.deleteByPK(uuid);

        String response = "Equipment has been deleted";

        return response;
    }

    @Override
    public String updateEquipment(EquipmentDto equipmentDto) {
        Equipment equipmentFromDao = equipmentDAO.findEquipmentById(equipmentDto.getId());

        equipmentDAO.deleteByPK(equipmentDto.getId());

        equipmentFromDao.setName(equipmentDto.getEquipmentName());
        equipmentFromDao.setId(equipmentDto.getId());

        String response = "Equipment has been updated" + equipmentDto.toString();

        return response;
    }

    @Override
    public EquipmentDto readEquipment(UUID id) {
        Equipment equipment = equipmentDAO.findEquipmentById(id);

        EquipmentDto equipmentDto = new EquipmentDto();

        equipmentDto.setEquipmentName(equipment.getName());
        equipmentDto.setId(equipment.getId());

        return equipmentDto;
    }
}

