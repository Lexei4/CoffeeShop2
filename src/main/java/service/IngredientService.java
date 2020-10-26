package service;

import model.Ingredient;

public interface IngredientService {
    void addIngredient(Ingredient ingredient);
    void deleteIngredient(Ingredient ingredient);
    void updateIngredient(Ingredient ingredient);
}
