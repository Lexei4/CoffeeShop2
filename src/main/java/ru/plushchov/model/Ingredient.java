package ru.plushchov.model;


import java.math.BigDecimal;
import java.util.UUID;

/**
 * Класс для работы с ингредиентами в напитках
 */
public class Ingredient implements  Identified<UUID>{
    /**
     * ID ингредиента
     */
    private UUID id;
    /**
     * Страна происхождения ингредиента
     */
    private String origin;
    /**
     * Количество данного ингредиента
     */
    private BigDecimal amount;
    /**
     * Цена ингредиента
     */
    private BigDecimal price;
    /**
     * Наименование ингредиента
     */
    private String name;

    /**
     * Метод, возвращающий ID ингредиента
      * @return id - id данного ингредиента
     */
    @Override
    public UUID getId() {
        return id;
    }

    /**
     * Метод, устанавливающий ID ингредиента
     * @param id - id данного ингредиента
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Метод, возвращающий страну происхождения ингредиента
     * @return origin - страна происхождения
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Метод, устанавливающий страну происхождения ингредиента
     * @param origin - страна происхождения
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Метод, возвращающий количество ингредиента
     * @return amount - количество
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Метод, устанавливающий количество ингредиента
     * @param amount - количество
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Метод, возвращающий цену ингредиента
     * @return price - цена ингредиента
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Метод, устанавливающий цену  ингредиента
     * @param price - цена ингредиента
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Метод, устанавливающий наименование ингредиента
     * @param name наименование ингредиента
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод, возвращающий наименование ингредиента
     * @return name - наименование ингредиента
     */
    public String getName() {
        return name;
    }

    public Ingredient() {
    }

    public Ingredient(String origin) {
        this.origin = origin;
    }

    public Ingredient(UUID id, String origin, BigDecimal amount, BigDecimal price, String name) {
        this.id = id;
        this.origin = origin;
        this.amount = amount;
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
