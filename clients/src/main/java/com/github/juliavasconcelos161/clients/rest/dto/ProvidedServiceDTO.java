package com.github.juliavasconcelos161.clients.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor//Cria construtor sem parâmetros
public class ProvidedServiceDTO {
    @NotEmpty(message = "{label.description.required}")
    private String description;
    @NotEmpty(message = "{label.price.required}")
    private String price;
    @NotEmpty(message = "{label.date.required}")
    private String date;
    @NotNull(message = "{label.client.required}")
    private Integer clientId;
}
