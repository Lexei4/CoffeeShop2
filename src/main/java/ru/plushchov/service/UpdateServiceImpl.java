package ru.plushchov.service;

import org.springframework.stereotype.Service;
import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;
import ru.plushchov.dao.BeverageDAO;
import ru.plushchov.dao.EquipmentDAO;
import ru.plushchov.dao.IngredientDAO;
import ru.plushchov.model.Beverage;
import ru.plushchov.model.Equipment;
import ru.plushchov.model.Ingredient;

@Service
public class UpdateServiceImpl implements UpdateService {

    private IngredientDAO ingredientDAO;
    private BeverageDAO beverageDAO;
    private EquipmentDAO equipmentDAO;

    public UpdateServiceImpl(IngredientDAO ingredientDAO, BeverageDAO beverageDAO, EquipmentDAO equipmentDAO) {
        this.ingredientDAO = ingredientDAO;
        this.beverageDAO = beverageDAO;
        this.equipmentDAO = equipmentDAO;
    }

    @Override
    public String updateIngredient(IngredientDto ingredientDto) {

        Ingredient ingredientFromDao = ingredientDAO.findIngredientById(ingredientDto.getId());

        ingredientDAO.deleteByPK(ingredientDto.getId());

        ingredientFromDao.setId(ingredientDto.getId());

        ingredientFromDao.setAmount(ingredientDto.getAmount());
        ingredientFromDao.setName(ingredientDto.getName());
        if (!ingredientDto.getOrigin().equals("Origin_not_set")) ingredientFromDao.setOrigin(ingredientDto.getOrigin());
        ingredientFromDao.setPrice(ingredientDto.getPrice());

        ingredientDAO.save(ingredientFromDao);

        String response = "Ingredient has been updated" + ingredientDto.toString();

        return response;
    }

    @Override
    public String updateBeverage(BeverageDto beverageDto) {

        Beverage beverageFromDao = beverageDAO.findBeverageById(beverageDto.getId());

        beverageDAO.deleteByPK(beverageDto.getId());

        beverageFromDao.setBeverageId(beverageDto.getId());
        beverageFromDao.setBeveragePrice(beverageDto.getBeveragePrice());
        beverageFromDao.setBeverageType(beverageDto.getBeverageType());

        beverageDAO.save(beverageFromDao);

        String response = "Beverage has been updated" + beverageDto.toString();

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
}
