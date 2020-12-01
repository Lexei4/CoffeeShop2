package ru.plushchov.controller.dto;

import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Data Transfer Object для оборудования
 */
public class EquipmentDto {

    /**
     * id оборудования
     */
    private UUID id;
    /**
     * наименование оборудования
     */
    private String equipmentName;
    /**
     * Список ошибок
     */
    private List<ObjectError> errors;

    public EquipmentDto() {
    }

    /**
     * Возвращает ID оборудования
     * @return id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Устанавливает ID оборудования
     * @param id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Возвращает наименование оборудования
     * @return equipmentName
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * Устанавливает наименование оборудования
     * @param equipmentName
     */
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
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

        return Objects.hash(equipmentName);
    }

}
