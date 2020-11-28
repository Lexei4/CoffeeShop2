package ru.plushchov.model;

import java.math.BigDecimal;
import java.util.List;

import java.util.UUID;

/**
 * Класс для работы с напитками
 */
public class Beverage implements Identified<UUID>{
    String beverageType;
    UUID id;
    BigDecimal beveragePrice;
    List<Equipment> equipmentList;
    List<Ingredient> ingredientList;

    public Beverage(){

    }
    public Beverage(String beverageType) {
        this.beverageType = beverageType;
    }

    public Beverage(UUID beverageId, String beverageType, BigDecimal beveragePrice) {
        this.id = beverageId;
        this.beverageType = beverageType;
        this.beveragePrice = beveragePrice;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "beverageType='" + beverageType + '\'' +
                ", beverageId=" + id +
                ", beveragePrice=" + beveragePrice +
                ", equipmentList=" + equipmentList +
                ", ingredientList=" + ingredientList +
                '}';
    }

    /**
     * Метод, возвращающий тип напитка
     * @return String beverageTyoe
     */
    public String getBeverageType() {
        return beverageType;
    }

    /**
     * Метод, устанавляивающий тип напитка
     * type of Beverage - Capucino, Latte, Espresso, Americano etc.
     */
    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    /**
     * Метод, возвращающий ID напитка
     * @return
     */
    @Override
    public UUID getId() {
        return id;
    }

    /**
     * Метод, устанавляивающий ID напитка
     * @param beverageId
     */
    public void setId(UUID beverageId) {
        this.id = beverageId;
    }


    /**
     * Метод, возвращающий цену напитка
     * @return
     */
    public BigDecimal getBeveragePrice() {
        return beveragePrice;
    }

    /**
     * Метод, устанавляивающий цену напитка
     * @param beveragePrice
     */
    public void setBeveragePrice(BigDecimal beveragePrice) {
        this.beveragePrice = beveragePrice;
    }

    /**
     * Метод, возвращающий список оборудования, используемый для приготовления напитка
     * @return
     */
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    /**
     * Метод, устанавливающий список оборудования, используемый для приготовления напитка
     * @param equipmentList
     */
    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    /**
     * Метод, возвращающий список ингредиентов, используемых для приготовления напитка
     * @return
     */
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    /**
     * Метод, устанавливающий список ингредиентов, используемых для приготовления напитка
     * @param ingredientList
     */
    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }


}
