package ru.plushchov.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;
import ru.plushchov.model.Beverage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

        IngredientService ingredientService = (IngredientService) context.getBean("ingredientService");
        EquipmentService equipmentService = (EquipmentService) context.getBean("equipmentService");

        IngredientDto coffeeBeans = new IngredientDto();
        coffeeBeans.setOrigin("Brazil");
        coffeeBeans.setAmount(new BigDecimal("200.00"));
        coffeeBeans.setId(UUID.randomUUID());
        coffeeBeans.setPrice(new BigDecimal("10.20"));

        ingredientService.addIngredient(coffeeBeans);

        IngredientDto milk = new IngredientDto();
        milk.setOrigin("Russia");
        milk.setAmount(new BigDecimal("10.00"));
        milk.setId(UUID.randomUUID());
        milk.setPrice(new BigDecimal("2.20"));

        ingredientService.addIngredient(milk);

        List cappuccinoIngredientList = new ArrayList();

        cappuccinoIngredientList.add(coffeeBeans);
        cappuccinoIngredientList.add(milk);


        EquipmentDto coffeeMachine = new EquipmentDto();
        coffeeMachine.setId(UUID.randomUUID());
        coffeeMachine.setEquipmentName("Marzoka coffeeMachine");

        equipmentService.addEquipment(coffeeMachine);

        EquipmentDto grinder = new EquipmentDto();
        grinder.setId(UUID.randomUUID());
        grinder.setEquipmentName("Simonelli mythos grinder");

        equipmentService.addEquipment(grinder);

        List cappuccinoEquipmentList = new ArrayList();
        cappuccinoEquipmentList.add(coffeeMachine);
        cappuccinoEquipmentList.add(grinder);

        Beverage cappuccino = new Beverage("Cappuccino");
        cappuccino.setId(UUID.randomUUID());
        cappuccino.setBeveragePrice(new BigDecimal("5.50"));
        cappuccino.setIngredientList(cappuccinoIngredientList);
        cappuccino.setEquipmentList(cappuccinoEquipmentList);
    }
}
