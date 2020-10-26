package model;

import java.math.BigDecimal;
import java.util.List;

import java.util.UUID;

public class Beverage implements Identified<UUID>{
    String beverageType; // type of Beverage - Capucino, Latte, Espresso, Americano
    UUID beverageId;
    BigDecimal beveragePrice; // retail price

    List<Equipment> equipmentList; // equipment needed to prepare this beverage
    List<Ingredient> ingredientList;



    @Override
    public String toString() {
        return "Beverage{" +
                "beverageType='" + beverageType + '\'' +
                ", beverageId=" + beverageId +
                ", beveragePrice=" + beveragePrice +
                ", equipmentList=" + equipmentList +
                ", ingredientList=" + ingredientList +
                '}';
    }

    public String getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    @Override
    public UUID getId() {

        return beverageId;
    }

    public void setBeverageId(UUID beverageId) {
        this.beverageId = beverageId;
    }

    public BigDecimal getBeveragePrice() {
        return beveragePrice;
    }

    public void setBeveragePrice(BigDecimal beveragePrice) {
        this.beveragePrice = beveragePrice;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }


}
