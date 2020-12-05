package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.service.BeverageService;

import java.util.UUID;

/**
 * REST -контроллер, обрабатыващий CRUD запросы к сущности beverage
 */
@RestController
@RequestMapping("/api/beverage")
public class BeverageController {
    private static final Logger log = LogManager.getLogger(BeverageController.class.getName());
    /**
     * Сервис, отвечающий за общение с DAO слоем
     */
    private BeverageService beverageService;

    @Autowired
    public BeverageController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    /**
     * Мапит POST запросы
     *
     * @param beverageDto - DTO напитка
     * @param result      - результат запроса
     * @return beverageDto с uuid
     */
    @PostMapping
    public BeverageDto beverageRegistration(@RequestBody BeverageDto beverageDto, BindingResult result) {

        if (result.hasErrors()) {
            beverageDto.setErrors(result.getAllErrors());
            return beverageDto;
        }

        beverageService.addBeverage(beverageDto);
        return beverageDto;
    }

    /**
     * мапинг GET - запросов
     *
     * @param id - id напитка, по кторому осуществляется поиск в БД
     * @return
     */
    @GetMapping
    public BeverageDto beverageRequestById(@RequestParam UUID id) {
        return beverageService.readBeverage(id);
    }

    /**
     * Мапинг update запросов
     *
     * @param beverageDto -  DTO напитка на которую осуществляется замена
     * @param result      - результат запроса
     * @return
     */
    @PutMapping
    public BeverageDto beverageUpdate(@RequestBody BeverageDto beverageDto, BindingResult result) {

        if (result.hasErrors()) {
            beverageDto.setErrors(result.getAllErrors());
            return beverageDto;
        }

        beverageService.updateBeverage(beverageDto);
        return beverageDto;
    }

    /**
     * Мапинг DELETE запросов
     *
     * @param id - id напитка для удаления
     * @return
     */
    @DeleteMapping
    public String beverageDeleteById(@RequestParam UUID id) {
        return beverageService.deleteBeverage(id);
    }

    /**
     * Связывает конкретный эллемент с конкретной сущностью
     *
     * @return
     */
    @ModelAttribute
    public BeverageDto beverageDto() {
        return new BeverageDto();
    }
}
