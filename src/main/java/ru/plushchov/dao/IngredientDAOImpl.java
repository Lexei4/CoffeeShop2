package ru.plushchov.dao;

import org.springframework.stereotype.Repository;
import ru.plushchov.model.Ingredient;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class IngredientDAOImpl extends AbstractDao<Ingredient, UUID> implements IngredientDAO {

    public IngredientDAOImpl() {
        super(Ingredient.class, new HashMap<>());
    }

    public boolean ingredientExist(String name){
        for (Ingredient el : elements.values()) {
            if (el.getOrigin().equals(name)) {
                return true;
            }
        }
        return false;
    };
    public Ingredient findIngredientById(UUID id){
        Ingredient ingredient = new Ingredient();

        for (Ingredient el : elements.values()) {
        if (el.getId().equals(id)) {
            ingredient.setAmmount(el.getAmount());
            ingredient.setPrice(el.getPrice());
            ingredient.setId(el.getId());
            ingredient.setName(el.getName());
            ingredient.setOrigin(el.getOrigin());
        }
    } 
        return ingredient;
        
    };

    public Ingredient findIngredientByName(String name){
        for (Ingredient el : elements.values()) {
            if (el.getName().equals(name)) {
                return el;
            }
        }
        return null;
    };
}
