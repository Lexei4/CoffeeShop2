package ru.plushchov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.plushchov.dao.BeverageDAO;
import ru.plushchov.model.Beverage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@PropertySource(value = {"classpath:application.properties"})
public class BeverageServiceImpl implements BeverageService{

    @Value("${beverage.maxIngredients}")
    private String maxIngredient;

    private static final Logger log = LogManager.getLogger(BeverageServiceImpl.class.getName());

    private BeverageDAO beverageDAO;

    public BeverageServiceImpl(BeverageDAO beverageDAO) {
        log.info("createService");
        this.beverageDAO = beverageDAO;
    }

    @Override
    public void addBeverage(Beverage beverage) {

        if (beverage.getIngredientList().size() >= Integer.valueOf(maxIngredient)){
            throw new RuntimeException("A beverage can consist only of maximum " + maxIngredient + " ingredients");
        }

        beverageDAO.save(beverage);
    }

    @Override
    public void deleteBeverage(Beverage beverage) {
        beverageDAO.delete(beverage);
    }

    @Override
    public void updateBeverage(Beverage beverage) {
        beverageDAO.update(beverage);
    }

    @Autowired
    public void setBeverageDAO(BeverageDAO beverageDAO) {
        this.beverageDAO = beverageDAO;
    }
}
