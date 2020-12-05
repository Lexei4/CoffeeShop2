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

    private BeverageService beverageService;

    @Autowired
    public BeverageController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }
    @PostMapping
    public BeverageDto beverageRegistration(@RequestBody BeverageDto beverageDto, BindingResult result) {

        if (result.hasErrors()) {
            beverageDto.setErrors(result.getAllErrors());
            return beverageDto;
        }

        beverageService.addBeverage(beverageDto);
        return beverageDto;
    }


    @GetMapping
    public BeverageDto beverageRequestById(@RequestParam UUID id) {
        return beverageService.readBeverage(id);
    }

    @PutMapping
    public BeverageDto beverageUpdate(@RequestBody BeverageDto beverageDto, BindingResult result) {

        if (result.hasErrors()) {
            beverageDto.setErrors(result.getAllErrors());
            return beverageDto;
        }

        beverageService.updateBeverage(beverageDto);
        return beverageDto;
    }

    @DeleteMapping
    public String beverageDeleteById(@RequestParam UUID id) {
        return beverageService.deleteBeverage(id);
    }

    @ModelAttribute
    /*Связывает конкретный эллемент с конкретной сущностью*/
    public BeverageDto beverageDto() {
        return new BeverageDto();
    }
}
