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
import com.demo.springandreact.domain.entity.Client;
import com.demo.springandreact.service.ClientService;

@RestController
@RequestMapping("/springandreact/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @PostMapping
  public void createClient(@RequestBody Client client) {
    clientService.createClient(client);
  }

  @GetMapping("/{name}")
  public Client getClient(@PathVariable String name) {
    return clientService.getClient(name);
  }

  @PutMapping("/{name}")
  public void updateClient(@PathVariable String name, @RequestBody Client client) {
    client.setName(name);
    clientService.updateClient(client);
  }

  @DeleteMapping("/{name}")
  public void deleteClient(@PathVariable String name) {
    clientService.deleteClient(name);
  }

  @GetMapping()
  public List<Client> getClients() {
    return clientService.getClients();
  }

}

