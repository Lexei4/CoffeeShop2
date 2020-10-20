package service;

import dao.IngridientDAO;
import model.Ingridient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

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
