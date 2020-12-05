package ru.plushchov.service.REST;

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
public class RequestServiceImpl implements  RequestService{

    private IngredientDAO ingredientDAO;
    private BeverageDAO beverageDAO;
    private EquipmentDAO equipmentDAO;

    public RequestServiceImpl(IngredientDAO ingredientDAO, BeverageDAO beverageDAO, EquipmentDAO equipmentDAO) {
        this.ingredientDAO = ingredientDAO;
        this.beverageDAO = beverageDAO;
        this.equipmentDAO = equipmentDAO;
    }

    @Override
    public IngredientDto reqIngredient(UUID uuid) {

        Ingredient ingredient = ingredientDAO.findIngredientById(uuid);

        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setAmount(ingredient.getAmount());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setOrigin(ingredient.getOrigin());
        ingredientDto.setPrice(ingredient.getPrice());

        return ingredientDto;
    }

    @Override
    public BeverageDto reqBeverage(UUID uuid) {

        Beverage beverage = beverageDAO.findBeverageById(uuid);

        BeverageDto beverageDto = new BeverageDto();

        beverageDto.setId(beverage.getId());
        beverageDto.setBeveragePrice(beverage.getBeveragePrice());
        beverageDto.setBeverageType(beverage.getBeverageType());


        return beverageDto;
    }

    @Override
    public EquipmentDto reqEquipment(UUID uuid) {

        Equipment equipment = equipmentDAO.findEquipmentById(uuid);

        EquipmentDto equipmentDto = new EquipmentDto();

        equipmentDto.setEquipmentName(equipment.getName());
        equipmentDto.setId(equipment.getId());

        return equipmentDto;
    }
}
