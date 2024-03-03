package com.ObjectValidator.validate.Controller;


import com.ObjectValidator.validate.Dto.GreetingDto;
import com.ObjectValidator.validate.Service.GreetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GreetingController
{
    private final GreetService greetService;

    @Autowired
    public GreetingController(GreetService greetService) {
        this.greetService = greetService;
    }

    @PostMapping("/greeting")
    public ResponseEntity<String> postGreeting(@RequestBody @Valid GreetingDto greetingDto,
                                               BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return ResponseEntity
                    .badRequest()
                    .body(bindingResult.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining()));
        }
        final String greetingMsg = greetService.saveGreeting(greetingDto);
        return ResponseEntity
                .accepted()
                .body(greetingMsg);
    }

}
