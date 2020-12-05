package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.service.REST.DeleteService;
import ru.plushchov.service.REST.RegistrationService;
import ru.plushchov.service.REST.RequestService;
import ru.plushchov.service.REST.UpdateService;

import java.util.UUID;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    private static final Logger log = LogManager.getLogger(EquipmentController.class.getName());

    private RegistrationService registrationService;
    private RequestService requestService;
    private UpdateService updateService;
    private DeleteService deleteService;

    @Autowired
    public EquipmentController(RegistrationService registrationService, RequestService requestService,
                               UpdateService updateService, DeleteService deleteService) {
        this.registrationService = registrationService;
        this.requestService = requestService;
        this.updateService = updateService;
        this.deleteService = deleteService;
    }

    @PostMapping
    public EquipmentDto equipmentRegistration(@RequestBody EquipmentDto equipmentDto,
                                              BindingResult result) {

        if (result.hasErrors()) {
            equipmentDto.setErrors(result.getAllErrors());
            return equipmentDto;
        }

        registrationService.regEquipment(equipmentDto);
        return equipmentDto;
    }

    @GetMapping
    public EquipmentDto equipmentRequestById(@RequestParam UUID id) {
        return requestService.reqEquipment(id);
    }

    @PutMapping
    public EquipmentDto equipmentUpdate(@RequestBody EquipmentDto equipmentDto, BindingResult result) {
        if (result.hasErrors()) {
            equipmentDto.setErrors(result.getAllErrors());
            return equipmentDto;
        }
        updateService.updateEquipment(equipmentDto);
        return equipmentDto;
    }

    @DeleteMapping
    public String equipmentDeleteById(@RequestParam UUID id) {
        return deleteService.deleteEquipment(id);
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
