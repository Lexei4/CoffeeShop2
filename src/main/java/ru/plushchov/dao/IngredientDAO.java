package ru.plushchov.dao;

import ru.plushchov.model.Ingredient;

import java.util.UUID;

public interface IngredientDAO extends GenericDAO<Ingredient, UUID>{

    boolean ingredientExist(String username);

    Ingredient findIngredientById(UUID id);

    Ingredient findIngredientByName(String name);

}
