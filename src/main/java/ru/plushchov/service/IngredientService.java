package ru.plushchov.service;

import ru.plushchov.model.Ingredient;

public interface IngredientService {
    void addIngredient(Ingredient ingredient);
    void deleteIngredient(Ingredient ingredient);
    void updateIngredient(Ingredient ingredient);
}

