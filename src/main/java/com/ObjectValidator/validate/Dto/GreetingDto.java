package com.ObjectValidator.validate.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreetingDto
{
    @NotNull(message = "The Message Should not Be Empty")
    @NotEmpty(message = "The Message Should not Be Empty")
    private String msg;

    @NotNull(message = "The from Should not Be Empty")
    @NotEmpty(message = "The from Should not Be Empty")
    private String from;

    @NotNull(message = "The to Should not Be Empty")
    @NotEmpty(message = "The to Should not Be Empty")
    private String to;
}
