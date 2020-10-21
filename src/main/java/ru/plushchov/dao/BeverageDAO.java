package ru.plushchov.dao;

import ru.plushchov.model.Beverage;

import java.util.UUID;

public interface BeverageDAO  extends GenericDAO<Beverage, UUID>{


    Beverage findBeverageById(int id);

    Beverage findBeverageByType(String name);
}
