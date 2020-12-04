package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.service.REST.DeleteService;
import ru.plushchov.service.REST.RegistrationService;
import ru.plushchov.service.REST.RequestService;
import ru.plushchov.service.REST.UpdateService;

import java.util.UUID;

/**
 * REST -контроллер, обрабатыващий CRUD запросы к сущности beverage
 */
@RestController
@RequestMapping("/api/beverage")
public class BeverageController {
    private static final Logger log = LogManager.getLogger(BeverageController.class.getName());

    private RegistrationService registrationService;
    private RequestService requestService;
    private UpdateService updateService;
    private DeleteService deleteService;

    @Autowired
    public BeverageController(RegistrationService registrationService, RequestService requestService,
                              UpdateService updateService, DeleteService deleteService) {
        this.registrationService = registrationService;
        this.requestService = requestService;
        this.updateService = updateService;
        this.deleteService = deleteService;
    }
    @PostMapping
    public BeverageDto beverageRegistration(@RequestBody BeverageDto beverageDto, BindingResult result) {

        if (result.hasErrors()) {
            beverageDto.setErrors(result.getAllErrors());
            return beverageDto;
        }

        registrationService.regBeverage(beverageDto);
        return beverageDto;
    }


    @GetMapping
    public BeverageDto beverageRequestById(@RequestParam UUID id) {
        return requestService.reqBeverage(id);
    }

    @PutMapping
    public BeverageDto beverageUpdate(@RequestBody BeverageDto beverageDto, BindingResult result) {

        if (result.hasErrors()) {
            beverageDto.setErrors(result.getAllErrors());
            return beverageDto;
        }

        updateService.updateBeverage(beverageDto);
        return beverageDto;
    }

    @DeleteMapping
    public String beverageDeleteById(@RequestParam UUID id) {
        return deleteService.deleteBeverage(id);
    }

    @ModelAttribute
    /*Связывает конкретный эллемент с конкретной сущностью*/
    public BeverageDto beverageDto() {
        return new BeverageDto();
    }
}
