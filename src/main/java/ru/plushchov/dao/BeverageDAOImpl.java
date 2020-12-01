package ru.plushchov.dao;

import org.springframework.stereotype.Repository;
import ru.plushchov.model.Beverage;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class   BeverageDAOImpl extends AbstractDao<Beverage, UUID> implements BeverageDAO {

    public BeverageDAOImpl() {
        super(Beverage.class, new HashMap<>());
    }

    @Override
    public Beverage findBeverageById(UUID id) {
        Beverage beverage = new Beverage();

        for (Beverage el : elements.values()) {
            if (el.getId().equals(id)) {
                beverage.setBeverageType(el.getBeverageType());
                beverage.setBeveragePrice(el.getBeveragePrice());
                beverage.setId(el.getId());
            }
        }
        return beverage;
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
