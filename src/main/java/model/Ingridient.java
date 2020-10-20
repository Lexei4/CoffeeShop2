package model;


import java.math.BigDecimal;
import java.util.UUID;

public class Ingridient implements  Identified<UUID>{
    private UUID id;
    private String origin;
    private double ammount;
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

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
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

    public Ingridient() {
    }

    public Ingridient(String origin) {
        this.origin = origin;
    }


    @Override
    public String toString() {
        return "Ingridient{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", ammount=" + ammount +
                ", price=" + price +
                '}';
    }
}
