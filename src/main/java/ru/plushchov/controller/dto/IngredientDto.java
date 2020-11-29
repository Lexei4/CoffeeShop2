package ru.plushchov.controller.dto;

import org.springframework.validation.ObjectError;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class IngredientDto {

    public IngredientDto() {
    }

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
     * Список ошибок
     */
    private List<ObjectError> errors;

    /**
     * Метод, возвращающий ID ингредиента
     * @return id - id данного ингредиента
     */
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
        if (origin == null) return "Origin_not_set";
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
     * Метод, возвращающий наименование ингредиента
     * @return name - наименование ингредиента
     */
    public String getName() {
        return name;
    }
    /**
     * Метод, устанавливающий наименование ингредиента
     * @param name наименование ингредиента
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает список ошибок
     * @return errors
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
    public int hashCode() {
        return Objects.hash(origin, amount, price, name);
    }
}
