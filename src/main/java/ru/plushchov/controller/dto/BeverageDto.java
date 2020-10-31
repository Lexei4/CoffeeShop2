package ru.plushchov.controller.dto;

import org.springframework.validation.ObjectError;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class BeverageDto {

    private UUID id;
    private String beverageType; // type of Beverage - Capucino, Latte, Espresso, Americano
    private BigDecimal beveragePrice; // retail price
    private List<ObjectError> errors;

    public BeverageDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    public BigDecimal getBeveragePrice() {
        return beveragePrice;
    }

    public void setBeveragePrice(BigDecimal beveragePrice) {
        this.beveragePrice = beveragePrice;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(beverageType, beveragePrice);
    }

}
