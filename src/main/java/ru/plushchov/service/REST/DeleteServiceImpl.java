package ru.plushchov.service.REST;

import org.springframework.stereotype.Service;
import ru.plushchov.dao.BeverageDAO;
import ru.plushchov.dao.EquipmentDAO;
import ru.plushchov.dao.IngredientDAO;

import java.util.UUID;

@Service
public class DeleteServiceImpl implements  DeleteService {

    private IngredientDAO ingredientDAO;
    private BeverageDAO beverageDAO;
    private EquipmentDAO equipmentDAO;

    public DeleteServiceImpl(IngredientDAO ingredientDAO, BeverageDAO beverageDAO, EquipmentDAO equipmentDAO) {
        this.ingredientDAO = ingredientDAO;
        this.beverageDAO = beverageDAO;
        this.equipmentDAO = equipmentDAO;
    }

    @Override
    public String deleteIngredient(UUID uuid) {

        ingredientDAO.deleteByPK(uuid);

        String response = "Ingredient has been deleted";

        return response;
    }

    @Override
    public String deleteBeverage(UUID uuid) {
        beverageDAO.deleteByPK(uuid);

        String response = "Beverage has been deleted";

        return response;
    }

    @Override
    public String deleteEquipment(UUID uuid) {
        equipmentDAO.deleteByPK(uuid);

        String response = "Equipment has been deleted";

        return response;
    }
}
