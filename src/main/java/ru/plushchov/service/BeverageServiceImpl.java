package ru.plushchov.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.dao.BeverageDAO;
import ru.plushchov.model.Beverage;

import java.util.UUID;

@Service
@PropertySource(value = {"classpath:application.properties"})
public class BeverageServiceImpl implements BeverageService {

    @Value("${beverage.maxIngredients}")
    private String maxIngredient;

    private static final Logger log = LogManager.getLogger(BeverageServiceImpl.class.getName());

    private BeverageDAO beverageDAO;

    public BeverageServiceImpl(BeverageDAO beverageDAO) {
        log.info("createService");
        this.beverageDAO = beverageDAO;
    }

    @Override
    public BeverageDto addBeverage(BeverageDto beverageDto) {
        Beverage beverage = new Beverage(
                UUID.randomUUID(), beverageDto.getBeverageType(), beverageDto.getBeveragePrice()
        );

        beverageDAO.save(beverage);
        beverageDto.setId(beverage.getId());

        return beverageDto;
    }

    @Override
    public String deleteBeverage(UUID uuid) {
        beverageDAO.deleteByPK(uuid);

        String response = "Beverage has been deleted";

        return response;
    }

    @Override
    public BeverageDto updateBeverage(BeverageDto beverageDto, UUID id) {

        if (beverageDto == null){
            BeverageDto beverageDtoNew = new BeverageDto();

            Beverage beverage = new Beverage(
                    id, "typeNeedsToBeSetUp", null
            );

            beverageDAO.save(beverage);
            beverageDtoNew.setId(id);
            beverageDtoNew.setBeveragePrice(beverage.getBeveragePrice());
            beverageDtoNew.setBeverageType(beverage.getBeverageType());
            return beverageDtoNew;
        }
        Beverage beverageFromDao = beverageDAO.findBeverageById(id);


            beverageDAO.deleteByPK(id);

            beverageFromDao.setId(beverageDto.getId());
            beverageFromDao.setBeveragePrice(beverageDto.getBeveragePrice());
            beverageFromDao.setBeverageType(beverageDto.getBeverageType());

            beverageDAO.save(beverageFromDao);

            return beverageDto;

    }


    @Override
    public BeverageDto readBeverage(UUID uuid) {
        Beverage beverage = beverageDAO.findBeverageById(uuid);

        BeverageDto beverageDto = new BeverageDto();

        beverageDto.setId(beverage.getId());
        beverageDto.setBeveragePrice(beverage.getBeveragePrice());
        beverageDto.setBeverageType(beverage.getBeverageType());


        return beverageDto;
    }

    public void setBeverageDAO(BeverageDAO beverageDAO) {
        this.beverageDAO = beverageDAO;
    }
}
