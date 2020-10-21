package ru.plushchov.service;

import org.springframework.stereotype.Service;
import ru.plushchov.dao.IngridientDAO;
import ru.plushchov.model.Ingridient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

@Service
public class IngridientServiceImpl implements IngridientService{

    private static final Logger log = LogManager.getLogger(IngridientServiceImpl.class.getName());

    private IngridientDAO ingridientDAO;

    public IngridientServiceImpl(IngridientDAO ingridientDAO) {
        log.info("createService");
        this.ingridientDAO = ingridientDAO;
    }

    @Override
    public void addIngredient(Ingridient ingridient) {
        log.info("now: " + LocalDateTime.now() +  " IngridientService: " + this.toString());
        ingridientDAO.save(ingridient);
    }

}
