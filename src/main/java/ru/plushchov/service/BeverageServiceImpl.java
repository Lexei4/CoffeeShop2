package ru.plushchov.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.plushchov.dao.BeverageDAO;
import ru.plushchov.model.Beverage;

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

    public void setBeverageDAO(BeverageDAO beverageDAO) {
        this.beverageDAO = beverageDAO;
    }
}
