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

    private EquipmentService equipmentService;

    @Autowired
    public EquipmentController( EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

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

    @GetMapping
    public EquipmentDto equipmentRequestById(@RequestParam UUID id) {

        return equipmentService.readEquipment(id);
    }

    @PutMapping
    public EquipmentDto equipmentUpdate(@RequestBody EquipmentDto equipmentDto, BindingResult result) {
        if (result.hasErrors()) {
            equipmentDto.setErrors(result.getAllErrors());
            return equipmentDto;
        }
        equipmentService.updateEquipment(equipmentDto);
        return equipmentDto;
    }

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
