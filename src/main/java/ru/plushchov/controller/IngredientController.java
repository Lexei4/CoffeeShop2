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
import ru.plushchov.service.IngredientService;
import ru.plushchov.validator.IngredientDtoValidator;

import java.util.UUID;

/**
 * REST - контроллер, обрабатыващий CRUD запросы к сущности ingredient
 */
@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    private static final Logger log = LogManager.getLogger(IngredientController.class.getName());

    private IngredientService ingredientService;
    private IngredientDtoValidator ingredientDtoValidator;

    @Autowired
    public IngredientController(IngredientService ingredientService,
                                IngredientDtoValidator ingredientDtoValidator) {
        this.ingredientService = ingredientService;
        this.ingredientDtoValidator = ingredientDtoValidator;
    }

    @PostMapping
    public ResponseEntity<IngredientDto> ingredientRegistration(@Validated @RequestBody IngredientDto ingredientDto,
                                                                BindingResult result) {
        if (result.hasErrors()) {
            ingredientDto.setErrors(result.getAllErrors());
            return new ResponseEntity<>(ingredientDto, HttpStatus.BAD_REQUEST);
        }

        ingredientService.addIngredient(ingredientDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("UUID of the registered ingredient",
                ingredientDto.getId().toString());

        return new ResponseEntity<>(ingredientDto, headers, HttpStatus.CREATED);
    }

    @GetMapping
    public IngredientDto ingredientRequestById(@RequestParam UUID id) {

        return ingredientService.readIngredient(id);
    }

    @PutMapping
    public String ingredientUpdate(@RequestBody IngredientDto ingredientDto, BindingResult result) {

        if (result.hasErrors()) {
            ingredientDto.setErrors(result.getAllErrors());
            return ingredientDto.getErrors().toString();
        }
        return ingredientService.updateIngredient(ingredientDto);
    }

    @DeleteMapping
    public String ingredientDeleteById(@RequestParam UUID id) {

        return ingredientService.deleteIngredient(id);
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
