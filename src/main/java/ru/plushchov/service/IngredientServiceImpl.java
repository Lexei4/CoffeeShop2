package ru.plushchov.service;

import org.springframework.stereotype.Service;
import ru.plushchov.dao.IngredientDAO;
import ru.plushchov.model.Ingredient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

@Service
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

}
