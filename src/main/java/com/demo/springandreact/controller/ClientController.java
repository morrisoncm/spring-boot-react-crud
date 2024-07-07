package com.demo.springandreact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springandreact.domain.dto.ClientDTO;
import com.demo.springandreact.domain.entity.Client;
import com.demo.springandreact.service.ClientService;

@RestController
@RequestMapping("/springandreact/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void createClient(@RequestBody ClientDTO clientDTO) {
        clientService.createClient(clientDTO);
    }

    @GetMapping("/{code}")
    public Client getClient(@PathVariable String code) {
        return clientService.getClient(code);
    }

    @PutMapping("/{code}")
    public void updateClient(@PathVariable String code, @RequestBody ClientDTO clientDTO) {
        clientDTO.setCode(code);
        clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/{code}")
    public void deleteClient(@PathVariable String code) {
        clientService.deleteClient(code);
    }

    @GetMapping()
    public List<Client> getClients() {
        return clientService.getClients();
    }

}

