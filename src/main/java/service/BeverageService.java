package service;

import model.Beverage;

public interface BeverageService {
    void addBeverage(Beverage beverage);
    void deleteBeverage(Beverage beverage);
    void updateBeverage(Beverage beverage);
}
