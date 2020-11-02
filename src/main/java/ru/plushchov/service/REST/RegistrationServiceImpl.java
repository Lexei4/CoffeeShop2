package ru.plushchov.service.REST;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService  {

    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class.getName());

    private IngredientDAO ingredientDAO;
    private BeverageDAO beverageDAO;
    private EquipmentDAO equipmentDAO;


    public RegistrationServiceImpl(IngredientDAO ingredientDAO, BeverageDAO beverageDAO, EquipmentDAO equipmentDAO) {
        this.ingredientDAO = ingredientDAO;
        this.beverageDAO = beverageDAO;
        this.equipmentDAO = equipmentDAO;
    }


    @Override
    public IngredientDto regIngredient(IngredientDto ingredientDto) {

        Ingredient ingredient = new Ingredient(
                UUID.randomUUID(), ingredientDto.getOrigin(),ingredientDto.getAmount(),
                ingredientDto.getPrice(), ingredientDto.getName()
        );

        ingredientDAO.save(ingredient);
        ingredientDto.setId(ingredient.getId());

        return ingredientDto;
    }

    @Override
    public BeverageDto regBeverage(BeverageDto beverageDto) {
        Beverage beverage = new Beverage(
                UUID.randomUUID(), beverageDto.getBeverageType(), beverageDto.getBeveragePrice()
        );

        beverageDAO.save(beverage);
        beverageDto.setId(beverage.getId());

        return beverageDto;
    }

    @Override
    public EquipmentDto regEquipment(EquipmentDto equipmentDto) {
        Equipment equipment = new Equipment(
                UUID.randomUUID(), equipmentDto.getEquipmentName()
        );

        equipmentDAO.save(equipment);
        equipmentDto.setId(equipment.getId());

        return equipmentDto;
    }


}
