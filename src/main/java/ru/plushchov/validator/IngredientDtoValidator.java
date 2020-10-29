package ru.plushchov.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.plushchov.controller.dto.IngredientDto;

import java.util.Locale;

@Component
public class IngredientDtoValidator implements Validator {

    private MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(IngredientDtoValidator.class.getName());

    public IngredientDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return IngredientDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        var userForm = (IngredientDto) target;

        if (userForm.getName().isEmpty()) {
            logger.error("ingredientname is empty");
            String message = messageSource.getMessage("ingredientname.empty", new Object[]{}, Locale.getDefault());
            errors.rejectValue("ingredientname", "ingredientname.empty", message);
        }

        if (errors.hasErrors()) return;

        //ToDo: make all fields validated

    }
}
