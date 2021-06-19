package com.vsemployeedetails.config;

import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * https://github.com/eugenp/tutorials/blob/master/spring-boot-rest/src/main/java/com/baeldung/spring/PersistenceConfig.java
 * HikariDataSource
 */
@Configuration
public class ApplicationConfig {

  @Bean
  public ObjectMapper ObjectMapper() {
    final ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper;
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
