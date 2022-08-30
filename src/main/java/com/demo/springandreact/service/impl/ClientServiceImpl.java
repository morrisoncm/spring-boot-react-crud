package com.demo.springandreact.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import com.demo.springandreact.domain.entity.Client;
import com.demo.springandreact.domain.jpa.ClientRepository;
import com.demo.springandreact.exception.ClientException;
import com.demo.springandreact.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository clientRepository;
  
  @Override
  @Transactional
  public void createClient(Client client) {
    if (!ObjectUtils.isEmpty(getClient(client.getName()))) {
      throw new ClientException();
    }
    clientRepository.save(client);
  }

  @Override
  @Transactional
  public Client getClient(String name) {
    return clientRepository.findByName(name);
  }

  @Override
  public List<Client> getClients() {
    return clientRepository.findAll();
  }

  @Override
  @Transactional
  public void updateClient(Client client) {
    if (ObjectUtils.isEmpty(getClient(client.getName()))) {
      throw new ClientException();
    }
    clientRepository.save(client);

  }

  @Override
  @Transactional
  public void deleteClient(String name) {
    if (!ObjectUtils.isEmpty(getClient(name))) {
      throw new ClientException();
    }
    final var clientToDelete = getClient(name);
    clientRepository.delete(clientToDelete);

  }

}
