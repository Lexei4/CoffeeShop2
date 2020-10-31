package ru.plushchov.controller.dto;

import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class EquipmentDto {

    private UUID id;

    private String equipmentName;

    private List<ObjectError> errors;

    public EquipmentDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }


    @Override
    public int hashCode() {

        return Objects.hash(equipmentName);
    }

}
