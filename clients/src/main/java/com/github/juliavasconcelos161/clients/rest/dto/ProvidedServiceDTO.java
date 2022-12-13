package com.github.juliavasconcelos161.clients.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//Cria construtor sem parâmetros
public class ProvidedServiceDTO {
    private String description;
    private String price;
    private String date;
    private Integer clientId;
}
