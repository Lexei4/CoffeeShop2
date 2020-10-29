package ru.plushchov.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.plushchov.controller.dto.IngredientDto;
import ru.plushchov.service.RegistrationService;
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

    @RequestMapping(method = RequestMethod.POST)
    public IngredientDto ingredientRegistration(@Validated @RequestBody IngredientDto ingredientDto, BindingResult result
            /*, HttpServletRequest httpServletRequest*/) {

//        userDtoValidator.validate(userDto, result);
        if (result.hasErrors()) {
            ingredientDto.setErrors(result.getAllErrors());
            return ingredientDto;
        }

        registrationService.regIngredient(ingredientDto);
        return ingredientDto;
    }

    @ModelAttribute
    public IngredientDto ingredientDto() {
        return new IngredientDto();
    }

    @InitBinder(value = "userDto")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(ingredientDtoValidator);
    }

}
