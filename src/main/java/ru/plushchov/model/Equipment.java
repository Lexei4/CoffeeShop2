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
    private String name;

    public Equipment() {
    }

    public Equipment(String name) {
        this.name = name;
    }

    public Equipment(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Метод, устанавливающий наименование оборудования
     * @param name - наименование оборудования
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Метод, возвращиющий наименование оборудования
     * @return name - наименование оборудования
     */
    public String getName(){
        return name;
    }

    /**
     * Метод, возвращиющий ID оборудования
     * @return id - id данношо оборудования
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
