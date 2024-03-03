package com.ObjectValidator.validate.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDto
{
    @NotNull
    private String a;

    @NotNull
    private String b;

    @NotNull
    private String c;
}
