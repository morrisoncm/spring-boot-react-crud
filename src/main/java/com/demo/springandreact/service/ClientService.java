package com.demo.springandreact.service;

import java.util.List;

import com.demo.springandreact.domain.dto.ClientDTO;
import com.demo.springandreact.domain.entity.Client;

public interface ClientService {

    void createClient(ClientDTO clientDTO);

    Client getClient(String code);

    List<Client> getClients();

    void updateClient(ClientDTO clientDTO);

    void deleteClient(String code);
}
