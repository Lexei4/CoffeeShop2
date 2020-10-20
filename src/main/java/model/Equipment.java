package model;

import java.util.List;
import java.util.UUID;

public abstract class Equipment implements  Identified<UUID>{

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

    public abstract String performAction(List<Ingridient> ingridients); // performs an action that is required by this equipment
}
