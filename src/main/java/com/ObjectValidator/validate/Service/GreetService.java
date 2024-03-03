package com.ObjectValidator.validate.Service;

import com.ObjectValidator.validate.Dto.ExampleDto;
import com.ObjectValidator.validate.Dto.GreetingDto;
import com.ObjectValidator.validate.Vadidator.ObjectValidator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GreetService
{
    @Autowired
    private final ObjectValidator<GreetingDto> validator;

    @Autowired
    private final ObjectValidator<ExampleDto> exampleDtoObjectValidator;


    public GreetService(ObjectValidator validator, ObjectValidator<ExampleDto> exampleDtoObjectValidator) {
        this.validator = validator;
        this.exampleDtoObjectValidator = exampleDtoObjectValidator;
    }


    public String saveGreeting(GreetingDto greetingDto)
    {
        var violation = validator.validate(greetingDto);
        if (!violation.isEmpty())
        {
            return String.join(" \n ", violation);
        }
        final String greetingMsg = "Greeting message <<" +
                greetingDto.getMsg()
                +">> From" + greetingDto.getMsg().toUpperCase()+
                "To :" +
                greetingDto.getTo().toUpperCase();
        return greetingMsg;

    }

    public String test(ExampleDto dto)
    {
        var violations = exampleDtoObjectValidator.validate(dto);
        return violations.toString();
    }


}
