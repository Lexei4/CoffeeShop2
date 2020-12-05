package ru.plushchov.model;

import java.math.BigDecimal;
import java.util.List;

import java.util.UUID;

/**
 * Класс для работы с напитками
 */
public class Beverage implements Identified<UUID> {
    /**
     * Тип напика. Latte, cappuccino, americanno, espresso.
     */
    private String beverageType;
    /**
     * ID напитка
     */
    private UUID id;
    /**
     * Стоимость напитка
     */
    private BigDecimal beveragePrice;
    /**
     * оборудование, задействованное в приготовлении напитка
     */
    private List<Equipment> equipmentList;
    /**
     * Ингредиенты, необходимые для приготовления напитка
     */
    private List<Ingredient> ingredientList;

    public Beverage() {

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
     *
     * @return String beverageTyoe - тип напитка
     */
    public String getBeverageType() {
        return beverageType;
    }

    /**
     * Метод, устанавляивающий тип напитка
     *
     * @param beverageType type of Beverage - Capзucсino, Latte, Espresso, Americano etc.
     */
    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    /**
     * Метод, возвращающий ID напитка
     *
     * @return id - id данного напитка
     */
    @Override
    public UUID getId() {
        return id;
    }

    /**
     * Метод, устанавляивающий ID напитка
     *
     * @param beverageId - id для данного напитка
     */
    public void setId(UUID beverageId) {
        this.id = beverageId;
    }

    /**
     * Метод, возвращающий цену напитка
     *
     * @return beveragePrice - цена данного напитка
     */
    public BigDecimal getBeveragePrice() {
        return beveragePrice;
    }

    /**
     * Метод, устанавляивающий цену напитка
     *
     * @param beveragePrice - цена данного напитка
     */
    public void setBeveragePrice(BigDecimal beveragePrice) {
        this.beveragePrice = beveragePrice;
    }

    /**
     * Метод, возвращающий список оборудования, используемый для приготовления напитка
     *
     * @return equipmentList - список оборудования
     */
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    /**
     * Метод, устанавливающий список оборудования, используемый для приготовления напитка
     *
     * @param equipmentList - список оборудования
     */
    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    /**
     * Метод, возвращающий список ингредиентов, используемых для приготовления напитка
     *
     * @return ingredientList - список ингредиентов
     */
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    /**
     * Метод, устанавливающий список ингредиентов, используемых для приготовления напитка
     *
     * @param ingredientList - список ингредиентов
     */
    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
