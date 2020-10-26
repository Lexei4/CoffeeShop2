package model;

import java.util.UUID;

public class Equipment implements  Identified<UUID>{

    private UUID id;



    String name; // CoffeeMachine, Grinder, Scale

    public Equipment() {
    }

    public Equipment(String name) {
        this.name = name;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}
