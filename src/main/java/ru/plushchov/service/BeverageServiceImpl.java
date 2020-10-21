package ru.plushchov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.plushchov.dao.BeverageDAO;
import ru.plushchov.model.Beverage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class BeverageServiceImpl implements BeverageService{

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

    @Autowired
    public void setBeverageDAO(BeverageDAO beverageDAO) {
        this.beverageDAO = beverageDAO;
    }
}
