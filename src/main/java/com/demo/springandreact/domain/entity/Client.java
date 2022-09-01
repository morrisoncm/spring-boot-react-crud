package com.demo.springandreact.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

  @Id
  @JsonIgnore
  @Column(name = "id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(name = "code")
  private String code;
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;

}
