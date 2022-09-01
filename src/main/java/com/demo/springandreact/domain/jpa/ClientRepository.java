package com.demo.springandreact.domain.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.springandreact.domain.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

  Client findByCode(String code);

}
