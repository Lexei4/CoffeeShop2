package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.plushchov.controller.dto.IngredientDto;
import ru.plushchov.service.REST.DeleteService;
import ru.plushchov.service.REST.RegistrationService;
import ru.plushchov.service.REST.RequestService;
import ru.plushchov.service.REST.UpdateService;
import ru.plushchov.validator.IngredientDtoValidator;

import java.util.UUID;

/**
 * REST - контроллер, обрабатыващий CRUD запросы к сущности ingredient
 */
@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    private static final Logger log = LogManager.getLogger(IngredientController.class.getName());

    private RegistrationService registrationService;
    private RequestService requestService;
    private UpdateService updateService;
    private DeleteService deleteService;
    private IngredientDtoValidator ingredientDtoValidator;

    @Autowired
    public IngredientController(RegistrationService registrationService, RequestService requestService,
                                UpdateService updateService, DeleteService deleteService,
                                IngredientDtoValidator ingredientDtoValidator) {
        this.registrationService = registrationService;
        this.requestService = requestService;
        this.updateService = updateService;
        this.deleteService = deleteService;
        this.ingredientDtoValidator = ingredientDtoValidator;
    }

    @PostMapping
    public ResponseEntity<IngredientDto> ingredientRegistration(@Validated @RequestBody IngredientDto ingredientDto,
                                                                BindingResult result) {
        if (result.hasErrors()) {
            ingredientDto.setErrors(result.getAllErrors());
            return new ResponseEntity<>(ingredientDto, HttpStatus.BAD_REQUEST);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", ingredientDto.getId().toString());

        registrationService.regIngredient(ingredientDto);
        return new ResponseEntity<>(ingredientDto, headers, HttpStatus.CREATED);
    }

    @GetMapping
    public IngredientDto ingredientRequestById(@RequestParam UUID id) {
        return requestService.reqIngredient(id);
    }

    @PutMapping
    public String ingredientUpdate(@RequestBody IngredientDto ingredientDto, BindingResult result) {

        if (result.hasErrors()) {
            ingredientDto.setErrors(result.getAllErrors());
            return ingredientDto.getErrors().toString();
        }
        return updateService.updateIngredient(ingredientDto);
    }

    @DeleteMapping
    public String ingredientDeleteById(@RequestParam UUID id) {
        return deleteService.deleteIngredient(id);
    }

    @ModelAttribute
    /*Связывает конкретный эллемент с конкретной сущностью*/
    public IngredientDto ingredientDto() {

        return new IngredientDto();
    }

    @InitBinder(value = "ingredientDto")
    /*связывает класс Валидатора с Контроллером*/
    private void initBinder(WebDataBinder binder) {

        binder.setValidator(ingredientDtoValidator);
    }
}
