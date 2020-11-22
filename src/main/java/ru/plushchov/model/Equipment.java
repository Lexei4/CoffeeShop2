package ru.plushchov.model;

import java.util.UUID;

/**
 * Класс для работы с оборудованием
 */
public class Equipment implements  Identified<UUID>{

    private UUID id;
    String name;

    public Equipment() {
    }

    public Equipment(String name) {
        this.name = name;
    }

    /**
     * Метод, устанавливающий наименование оборудования
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Метод, возвращиющий наименование оборудования
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Метод, возвращиющий ID оборудования
     * @return
     */
    @Override
    public UUID getId() {
        return id;
    }

    /**
     * Метод, устанавливающий ID оборудования
     * @param id
     */
    public void setId(UUID id) {
        this.id = id;
    }
}
