package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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
     * Сервис, отвечающий за общение с DAO слоем
     */
    private EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    /**
     * Мапит POST запросы
     *
     * @param equipmentDto - DTO ингредиента
     * @param result       - результат запроса
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
     *
     * @param id - id оборудования, по кторому осуществляется поиск в БД
     * @return
     */
    @GetMapping("{id}")
    public EquipmentDto equipmentRequestById(@PathVariable UUID id) {

        return equipmentService.readEquipment(id);
    }

    /**
     *
     * @param id - id оборудования
     * @param equipmentDto - DTO оборудования на которую осуществляется замена
     * @param componentsBuilder - переменная для возврата корректного ответа
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<EquipmentDto> equipmentUpdate(@PathVariable UUID id, @RequestBody(required = false) EquipmentDto equipmentDto, UriComponentsBuilder componentsBuilder) {

        var result = equipmentService.updateEquipment(equipmentDto, id);
        var uri = componentsBuilder.path("/api/beverage/" + result.getId()).buildAndExpand(result).toUri();
        if (equipmentDto == null){
            return ResponseEntity.created(uri).body(result);
        }
        else {
            return ResponseEntity.ok().body(result);
        }
    }

    /**
     * Мапинг DELETE запросов
     *
     * @param id - id оборудования для удаления
     * @return
     */
    @DeleteMapping("{id}")
    public String equipmentDeleteById(@PathVariable UUID id) {

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
