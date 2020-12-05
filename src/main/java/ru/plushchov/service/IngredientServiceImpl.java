package ru.plushchov.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.plushchov.controller.dto.IngredientDto;
import ru.plushchov.dao.IngredientDAO;
import ru.plushchov.model.Ingredient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
     * addIngridient is a Service method which will only work if price of the ingridient is less than one stipulated in
     * the property file
     */
    @Override
    public IngredientDto addIngredient(IngredientDto ingredientDto) {
        BigDecimal price = new BigDecimal("200");

        if (ingredientDto.getPrice().compareTo(price) > 0) {
            throw new RuntimeException("A beverage can consist only of ingredient which maximum price is " + maxIngredientPrice);
        }
        log.info("now: " + LocalDateTime.now() + " IngredientService: " + this.toString());

        Ingredient ingredient = new Ingredient(
                UUID.randomUUID(), ingredientDto.getOrigin(), ingredientDto.getAmount(),
                ingredientDto.getPrice(), ingredientDto.getName()
        );

        ingredientDAO.save(ingredient);
        ingredientDto.setId(ingredient.getId());

        return ingredientDto;
    }

    @Override
    public String deleteIngredient(UUID uuid) {

        ingredientDAO.deleteByPK(uuid);

        String response = "Ingredient has been deleted";

        return response;
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
    public IngredientDto readIngredient(UUID uuid) {
        Ingredient ingredient = ingredientDAO.findIngredientById(uuid);

        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setAmount(ingredient.getAmount());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setOrigin(ingredient.getOrigin());
        ingredientDto.setPrice(ingredient.getPrice());

        return ingredientDto;
    }

}
