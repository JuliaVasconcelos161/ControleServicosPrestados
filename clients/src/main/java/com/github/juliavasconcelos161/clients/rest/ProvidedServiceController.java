package com.github.juliavasconcelos161.clients.rest;

import com.github.juliavasconcelos161.clients.model.entities.Client;
import com.github.juliavasconcelos161.clients.model.entities.ProvidedService;
import com.github.juliavasconcelos161.clients.model.repository.ClientRepository;
import com.github.juliavasconcelos161.clients.model.repository.ProvidedServiceRepository;
import com.github.juliavasconcelos161.clients.rest.dto.ProvidedServiceDTO;
import com.github.juliavasconcelos161.clients.util.BigDecimalConversion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/provided-services")
@RequiredArgsConstructor
public class ProvidedServiceController {


    private final ClientRepository clientRepository;
    private final ProvidedServiceRepository repository;
    private final BigDecimalConversion bigDecimalConversion;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProvidedService saveService(@RequestBody ProvidedServiceDTO dto)
    {
        LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer clientId = dto.getClientId();

        Client client = clientRepository
                .findById(clientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));
        ProvidedService providedService = new ProvidedService();
        providedService.setDescription(dto.getDescription());
        providedService.setDate(date);
        providedService.setClient(client);
        providedService.setValue(bigDecimalConversion.convert(dto.getPrice()));
        return repository.save(providedService);
    }

    @GetMapping
    public List<ProvidedService> search(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "month", required = false) Integer month)
    {
        return repository.findByNameAndMonth("%" + name + "%", month);
    }
}
