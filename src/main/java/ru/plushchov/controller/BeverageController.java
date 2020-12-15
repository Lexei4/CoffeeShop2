package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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

    public BeverageController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    /**
     * Мапит POST запросы
     * @param beverageDto - DTO напитка
     * @param componentsBuilder - эллемент для составления ответа
     * @return
     */
    @PostMapping
    public ResponseEntity<BeverageDto> beverageRegistration(@RequestBody BeverageDto beverageDto, UriComponentsBuilder componentsBuilder) {

        var result = beverageService.addBeverage(beverageDto);
        var uri = componentsBuilder.path("/api/beverage/" + result.getId()).buildAndExpand(result).toUri();
        return ResponseEntity.created(uri).body(result);
    }


    /**
     * мапинг GET - запросов
     *
     * @param id - id напитка, по кторому осуществляется поиск в БД
     * @return
     */
    @GetMapping("{id}")
    public BeverageDto beverageRequestById(@PathVariable UUID id) {

        return beverageService.readBeverage(id);
    }

    /**
     * Мапинг update запросов
     * @param id - id напитка
     * @param beverageDto -  DTO напитка на которую осуществляется замена
     * @param componentsBuilder - переменная для возврата корректного ответа
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<BeverageDto> beverageUpdate(@PathVariable UUID id, @RequestBody(required = false) BeverageDto beverageDto, UriComponentsBuilder componentsBuilder) {

       var result = beverageService.updateBeverage(beverageDto, id);
       var uri = componentsBuilder.path("/api/beverage/" + result.getId()).buildAndExpand(result).toUri();
       if (beverageDto == null){
           return ResponseEntity.created(uri).body(result);
       }
           else {
           return ResponseEntity.ok().body(result);
       }
    }


    /**
     * Мапинг DELETE запросов
     *
     * @param id - id напитка для удаления
     * @return
     */
    @DeleteMapping("{id}")
    public String beverageDeleteById(@PathVariable UUID id) {
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
