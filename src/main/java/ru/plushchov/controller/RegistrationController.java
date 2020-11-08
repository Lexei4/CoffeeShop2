package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.plushchov.controller.dto.BeverageDto;
import ru.plushchov.controller.dto.EquipmentDto;
import ru.plushchov.controller.dto.IngredientDto;
import ru.plushchov.service.REST.RegistrationService;
import ru.plushchov.validator.IngredientDtoValidator;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private static final Logger logger = LogManager.getLogger(RegistrationController.class.getName());

    private RegistrationService registrationService;
    private IngredientDtoValidator ingredientDtoValidator;

    @Autowired
    public RegistrationController(RegistrationService registrationService, IngredientDtoValidator ingredientDtoValidator) {
        this.registrationService = registrationService;
        this.ingredientDtoValidator = ingredientDtoValidator;
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST)
    @RequestMapping("/ingredient")
    public ResponseEntity <IngredientDto> ingredientRegistration(@RequestBody IngredientDto ingredientDto,
                                                                 UriComponentsBuilder componentsBuilder) {
        var result = registrationService.regIngredient(ingredientDto);
        var uri = componentsBuilder.path("/api/ingredient/" + result.getId()).buildAndExpand(result).toUri();
        return ResponseEntity.created(uri).body(result);

//        registrationService.regIngredient(ingredientDto);
//        return new ResponseEntity<>(ingredientDto, HttpStatus.CREATED);
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

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/beverage")
    public BeverageDto beverageRegistration(@RequestBody BeverageDto beverageDto, BindingResult result
            /* , HttpServletRequest httpServletRequest*/) {

        if (result.hasErrors()) {
            beverageDto.setErrors(result.getAllErrors());
            return beverageDto;
        }

        registrationService.regBeverage(beverageDto);
        return beverageDto;
    }

    @ModelAttribute
    /*Связывает конкретный эллемент с конкретной сущностью*/
    public BeverageDto beverageDto() {

        return new BeverageDto();
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/equipment")
    public EquipmentDto equipmentRegistration(@RequestBody EquipmentDto equipmentDto, BindingResult result
            /* , HttpServletRequest httpServletRequest*/) {

        if (result.hasErrors()) {
            equipmentDto.setErrors(result.getAllErrors());
            return equipmentDto;
        }

        registrationService.regEquipment(equipmentDto);
        return equipmentDto;
    }

    @ModelAttribute
    /*Связывает конкретный эллемент с конкретной сущностью*/
    public EquipmentDto equipmentDto() {

        return new EquipmentDto();
    }



}
