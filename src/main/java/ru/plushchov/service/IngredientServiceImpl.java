package ru.plushchov.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.plushchov.dao.IngredientDAO;
import ru.plushchov.model.Ingredient;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@PropertySource(value = {"classpath:application.properties"})
public class IngredientServiceImpl implements IngredientService {

    @Value("${ingredient.maxPrice}")
    private String maxIngredientPrice;
    private static final Logger log = LogManager.getLogger(IngredientServiceImpl.class.getName());
    private IngredientDAO ingredientDAO;

    public IngredientServiceImpl(IngredientDAO ingredientDAO) {
        log.info("createService");
        this.ingredientDAO = ingredientDAO;
    }
/**
addIngridient is a Service method which will only work if price of the ingridient is less than one stipulated in
 the property file
 */
    @Override
    public void addIngredient(Ingredient ingredient) {
        BigDecimal price = new BigDecimal("200");

        if (ingredient.getPrice().compareTo(price) > 0)
        {
            throw new RuntimeException("A beverage can consist only of maximum " + maxIngredientPrice + " ingredients");
        }
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
