package ru.plushchov.model;


import java.math.BigDecimal;
import java.util.UUID;

/**
 * Класс для работы с ингредиентами в напитках
 */
public class Ingredient implements  Identified<UUID>{
    private UUID id;
    private String origin;
    private BigDecimal amount;
    private BigDecimal price;
    private String name;

    /**
     * Метод, возвращающий ID ингредиента
      * @return
     */
    @Override
    public UUID getId() {
        return id;
    }

    /**
     * Метод, устанавливающий ID ингредиента
     * @param id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Метод, возвращающий страну происхождения ингредиента
     * @return
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Метод, устанавливающий страну происхождения ингредиента
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Метод, возвращающий количество ингредиента
     * @return
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Метод, устанавливающий количество ингредиента
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Метод, возвращающий цену ингредиента
     * @return
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Метод, устанавливающий цену  ингредиента
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Метод, устанавливающий наименование ингредиента
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод, возвращающий наименование ингредиента
     * @return
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
