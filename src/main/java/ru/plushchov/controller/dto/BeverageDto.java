package ru.plushchov.controller.dto;

import org.springframework.validation.ObjectError;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class BeverageDto {

    /**
     * id напитка
     */
    private UUID id;
    /**
     * type of Beverage - Capucino, Latte, Espresso, Americano
     */
    private String beverageType;
    /**
     * retail price
     */
    private BigDecimal beveragePrice;
    /**
     * Список ошибок
     */
    private List<ObjectError> errors;

    public BeverageDto() {
    }

    /**
     * возвращает ID напитка
     * @return id
     */
    public UUID getId() {
        return id;
    }

    /**
     * устанавливает ID напитка
     * @param id напитка
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     *
     * @return наименование  напитка
     */
    public String getBeverageType() {
        return beverageType;
    }

    /**
     * устанавливает наименование  напитка
     * @param beverageType наименование  напитка
     */
    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    /**
     * возвращает цену напитка
     * @return beveragePrice
     */
    public BigDecimal getBeveragePrice() {
        return beveragePrice;
    }

    /**
     * Устанавливает цену напитка
     * @param beveragePrice
     */
    public void setBeveragePrice(BigDecimal beveragePrice) {
        this.beveragePrice = beveragePrice;
    }

    /**
     * возвращает список ошибок
     * @return List errors
     */
    public List<ObjectError> getErrors() {
        return errors;
    }

    /**
     * Устанавливает список ошибок
     * @param errors
     */
    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(beverageType, beveragePrice);
    }

}
