package com.demo.springandreact.test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.springandreact.controller.ClientController;

class ContextTest {
 
  @Autowired
  private ClientController controller;
  
  @Test
  void contextLoads() throws Exception {
      assertThat(controller).isNotNull();
  }
}
