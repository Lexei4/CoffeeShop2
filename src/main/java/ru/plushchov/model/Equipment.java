package ru.plushchov.model;

import java.util.UUID;

/**
 * Класс для работы с оборудованием
 */
public class Equipment implements  Identified<UUID>{

    /**
     * ID оборудования
     */
    private UUID id;
    /**
     * Наименование оборудования
     */
    private String equipmentName;

    public Equipment() {
    }

    public Equipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Equipment(UUID id, String equipmentName) {
        this.id = id;
        this.equipmentName = equipmentName;
    }

    /**
     * Метод, устанавливающий наименование оборудования
     * @param equipmentName - наименование оборудования
     */
    public void setName(String equipmentName){
        this.equipmentName = equipmentName;
    }

    /**
     * Метод, возвращиющий наименование оборудования
     * @return name - наименование оборудования
     */
    public String getName(){
        return equipmentName;
    }

    /**
     * Метод, возвращиющий ID оборудования
     * @return id - id данного оборудования
     */
    @Override
    public UUID getId() {
        return id;
    }

    /**
     * Метод, устанавливающий ID оборудования
     * @param id id данношо оборудования
     */
    public void setId(UUID id) {
        this.id = id;
    }
}
