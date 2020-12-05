package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.service.EquipmentService;

import java.util.UUID;

/**
 * REST - контроллер, обрабатыващий CRUD запросы к сущности beverage
 */
@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    private static final Logger log = LogManager.getLogger(EquipmentController.class.getName());
    /**
     *  Сервис, отвечающий за общение с DAO слоем
     */
    private EquipmentService equipmentService;

    @Autowired
    public EquipmentController( EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    /**
     * Мапит POST запросы
     * @param equipmentDto - DTO ингредиента
     * @param result - результат запроса
     * @return
     */
    @PostMapping
    public EquipmentDto equipmentRegistration(@RequestBody EquipmentDto equipmentDto,
                                              BindingResult result) {

        if (result.hasErrors()) {
            equipmentDto.setErrors(result.getAllErrors());
            return equipmentDto;
        }

        equipmentService.addEquipment(equipmentDto);
        return equipmentDto;
    }

    /**
     * мапинг GET - запросов
     * @param id - id оборудования, по кторому осуществляется поиск в БД
     * @return
     */
    @GetMapping
    public EquipmentDto equipmentRequestById(@RequestParam UUID id) {

        return equipmentService.readEquipment(id);
    }

    /**
     * Мапинг update запросов
     * @param equipmentDto - DTO оборудования на которую осуществляется замена
     * @param result - результат запроса
     * @return
     */
    @PutMapping
    public EquipmentDto equipmentUpdate(@RequestBody EquipmentDto equipmentDto, BindingResult result) {
        if (result.hasErrors()) {
            equipmentDto.setErrors(result.getAllErrors());
            return equipmentDto;
        }
        equipmentService.updateEquipment(equipmentDto);
        return equipmentDto;
    }

    /**
     * Мапинг DELETE запросов
     * @param id - id оборудования для удаления
     * @return
     */
    @DeleteMapping
    public String equipmentDeleteById(@RequestParam UUID id) {

        return equipmentService.deleteEquipment(id);
    }

    /***
     * Связывает конкретный эллемент с конкретной сущностью
     * @return EquipmentDto - DTO для оборудования
     */
    @ModelAttribute
    public EquipmentDto equipmentDto() {
        return new EquipmentDto();
    }
}
