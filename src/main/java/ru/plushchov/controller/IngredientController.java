package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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
    /**
     * Сервис, отвечающий за общение с DAO слоем
     */
    private IngredientService ingredientService;
    /**
     * Валидатор
     */
    private IngredientDtoValidator ingredientDtoValidator;

    public IngredientController(IngredientService ingredientService,
                                IngredientDtoValidator ingredientDtoValidator) {
        this.ingredientService = ingredientService;
        this.ingredientDtoValidator = ingredientDtoValidator;
    }

    /**
     * Мапит POST запросы
     *
     * @param ingredientDto - DTO ингредиента
     * @param         - результат запроса
     * @return
     */
    @PostMapping
    public ResponseEntity<IngredientDto> ingredientRegistration(@Validated @RequestBody IngredientDto ingredientDto,
                                                                UriComponentsBuilder componentsBuilder) {

        var result =  ingredientService.addIngredient(ingredientDto);

        var uri = componentsBuilder.path("/api/ingredient/" + result.getId()).buildAndExpand(result).toUri();
        return ResponseEntity.created(uri).body(result);

    }

    /**
     * мапинг GET - запросов
     *
     * @param id - id ингредиента, по кторому осуществляется поиск в БД
     * @return
     */
    @GetMapping("{id}")
    public IngredientDto ingredientRequestById(@PathVariable UUID id) {

        return ingredientService.readIngredient(id);
    }

    /**
     * Мапинг update запросов
     *
     * @param ingredientDto - DTO ингредиента на которую осуществляется замена
     * @param result        - результат запроса
     * @return
     */
    @PutMapping
    public String ingredientUpdate(@RequestBody IngredientDto ingredientDto, BindingResult result) {

        if (result.hasErrors()) {
            ingredientDto.setErrors(result.getAllErrors());
            return ingredientDto.getErrors().toString();
        }
        return ingredientService.updateIngredient(ingredientDto);
    }

    /**
     * Мапинг DELETE запросов
     *
     * @param id - id ингредиента для удаления
     * @return
     */
    @DeleteMapping("{id}")
    public String ingredientDeleteById(@PathVariable UUID id) {

        return ingredientService.deleteIngredient(id);
    }

    /**
     * Связывает конкретный эллемент с конкретной сущностью
     *
     * @return IngredientDto
     */
    @ModelAttribute
    public IngredientDto ingredientDto() {
        return new IngredientDto();
    }

    /**
     * связывает класс Валидатора с Контроллером
     *
     * @param binder
     */
    @InitBinder(value = "ingredientDto")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(ingredientDtoValidator);
    }
}
