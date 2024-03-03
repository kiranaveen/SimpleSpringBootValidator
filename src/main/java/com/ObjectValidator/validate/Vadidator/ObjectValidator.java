package com.ObjectValidator.validate.Vadidator;

import com.ObjectValidator.validate.Dto.GreetingDto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

;import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class ObjectValidator<T> {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private final Validator validation =  factory.getValidator();

    public Set<String> validate(T objectToValidate)
    {
        Set<ConstraintViolation<T>> violation = validation.validate(objectToValidate);
        if(!violation.isEmpty())
        {
            return violation.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }
}