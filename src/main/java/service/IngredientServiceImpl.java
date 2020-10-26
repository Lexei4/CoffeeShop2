package service;

import dao.IngredientDAO;
import model.Ingredient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class IngredientServiceImpl implements IngredientService {

    private static final Logger log = LogManager.getLogger(IngredientServiceImpl.class.getName());

    private IngredientDAO ingredientDAO;

    public IngredientServiceImpl(IngredientDAO ingredientDAO) {
        log.info("createService");
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        log.info("now: " + LocalDateTime.now() +  " IngredientService: " + this.toString());
        ingredientDAO.save(ingredient);
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        ingredientDAO.delete(ingredient);
    }

    @Override
    public void updateIngredient(Ingredient ingredient) {
        ingredientDAO.update(ingredient);
    }

}
