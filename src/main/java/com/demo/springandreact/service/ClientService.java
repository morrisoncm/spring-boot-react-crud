package com.demo.springandreact.service;

import java.util.List;
import com.demo.springandreact.domain.entity.Client;

public interface ClientService {

  void createClient(Client client);

  Client getClient(String name);

  List<Client> getClients();

  void updateClient(Client client);

  void deleteClient(String name);
}
