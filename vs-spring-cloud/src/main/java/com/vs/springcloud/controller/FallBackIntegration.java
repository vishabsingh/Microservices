package com.vs.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class FallBackIntegration {

  @GetMapping("/employeeServiceFallBack")
  public String fallBackMethodForEmployee() {
    return "Employee Microservice is Down";
  }

  @HystrixCommand(fallbackMethod = "save")
  public Object postEmployee() {
    return "Not Working";
  }


}
