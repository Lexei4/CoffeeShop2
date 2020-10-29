package ru.plushchov.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.plushchov.controller.dto.IngredientDto;
import ru.plushchov.dao.IngredientDAO;
import ru.plushchov.model.Ingredient;

import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService  {

    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class.getName());

    private IngredientDAO ingredientDAO;

    public RegistrationServiceImpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
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
}
