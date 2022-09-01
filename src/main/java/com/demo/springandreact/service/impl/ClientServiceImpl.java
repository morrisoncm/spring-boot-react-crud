package com.demo.springandreact.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;
import com.demo.springandreact.domain.dto.ClientDTO;
import com.demo.springandreact.domain.entity.Client;
import com.demo.springandreact.domain.jpa.ClientRepository;
import com.demo.springandreact.service.ClientService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Override
  @Transactional
  public Client getClient(String code) {
    return clientRepository.findByCode(code);
  }

  @Override
  public List<Client> getClients() {
    return clientRepository.findAll();
  }
  
  @Override
  @Transactional
  public void createClient(ClientDTO clientDTO) {
    if (!ObjectUtils.isEmpty(getClient(clientDTO.getName()))) {
      log.error("createClient() -> exception clientDTO {} found", clientDTO);
      throw new ResponseStatusException(HttpStatus.FOUND, "Client Found");
    }
    try {
      Client client = new Client();
      BeanUtils.copyProperties(client, clientDTO);
      clientRepository.save(client);
    } catch (IllegalAccessException | InvocationTargetException cause) {
      log.error("createClient() -> clientDTO {}", clientDTO, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client Not Created");
    }
  }

  @Override
  @Transactional
  public void updateClient(ClientDTO clientDTO) {
    Client clientFromDb = getClient(clientDTO.getCode());
    if (ObjectUtils.isEmpty(clientFromDb)) {
      log.error("updateClient() -> exception clientDTO {} not found", clientDTO);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Not Found");
    }
    try {
      BeanUtils.copyProperties(clientFromDb, clientDTO);
      clientRepository.save(clientFromDb);
    } catch (IllegalAccessException | InvocationTargetException cause) {
      log.error("updateClient() -> clientDTO {}", clientDTO, cause);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client Not Updated");
    }
  }

  @Override
  @Transactional
  public void deleteClient(String code) {
    var clientToDelete = getClient(code);
    if (ObjectUtils.isEmpty(clientToDelete)) {
      log.error("deleteClient() -> exception code {} not found", code);
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Not Found");
    }
    clientRepository.delete(clientToDelete);
  }

}
