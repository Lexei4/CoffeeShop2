package ru.plushchov.dao;

import ru.plushchov.model.Beverage;

import java.util.HashMap;
import java.util.UUID;

//@Repository
public class   BeverageDAOImpl extends AbstractDao<Beverage, UUID> implements BeverageDAO {

//    private BeverageDAO beverageDAO;

    public BeverageDAOImpl() {
        super(Beverage.class, new HashMap<>());
    }

    @Override
    public Beverage findBeverageById(int id) {
        for (Beverage el : elements.values()) {
            if (el.getId().equals(id)) {
                return el;
            }
        }
        return null;
    }

    @Override
    public Beverage findBeverageByType(String type) {
        for (Beverage el : elements.values()) {
            if (el.getBeverageType().equals(type)) {
                return el;
            }
        }
        return null;
    }

}
