package service;

import dao.BeverageDAO;
import dao.IngridientDAO;
import model.Beverage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BeverageServiceImpl implements BeverageService{

    private static final Logger log = LogManager.getLogger(IngridientServiceImpl.class.getName());

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

}
