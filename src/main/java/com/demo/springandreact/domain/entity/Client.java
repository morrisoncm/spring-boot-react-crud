package com.demo.springandreact.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String email;

}
