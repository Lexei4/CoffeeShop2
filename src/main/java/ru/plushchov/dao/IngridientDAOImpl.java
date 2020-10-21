package ru.plushchov.dao;

import ru.plushchov.model.Ingridient;

import java.util.HashMap;
import java.util.UUID;

//@Repository
public class IngridientDAOImpl extends AbstractDao<Ingridient, UUID> implements IngridientDAO {

    public IngridientDAOImpl() {
        super(Ingridient.class, new HashMap<>());
    }

    public boolean ingridientExist(String name){
        for (Ingridient el : elements.values()) {
            if (el.getOrigin().equals(name)) {
                return true;
            }
        }
        return false;
    };
    public Ingridient findIngridientById(String id){
        for (Ingridient el : elements.values()) {
        if (el.getId().equals(id)) {
            return el;
        }
    }
        return null;
    };

    public Ingridient findIngridientByName(String name){
        for (Ingridient el : elements.values()) {
            if (el.getName().equals(name)) {
                return el;
            }
        }
        return null;
    };
}
