package com.webapi.main.services.application;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
@ComponentScan("com.webapi.main.services")
public class FrameworkConfig {
 
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public AuditorAware<String> auditorAware() {
    return new SpringSecurityAuditorAware();
  }
}
