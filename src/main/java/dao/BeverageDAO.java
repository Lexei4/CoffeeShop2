package dao;

import model.Beverage;

import java.util.UUID;

public interface BeverageDAO  extends GenericDAO<Beverage, UUID>{


    Beverage findBeverageById(int id);

    Beverage findBeverageByType(String name);
}
