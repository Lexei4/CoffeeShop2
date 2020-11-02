package ru.plushchov.model;


import java.math.BigDecimal;
import java.util.UUID;

public class Ingredient implements  Identified<UUID>{
    private UUID id;
    private String origin;
    private BigDecimal amount;
    private BigDecimal price;
    private String name;



    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

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
