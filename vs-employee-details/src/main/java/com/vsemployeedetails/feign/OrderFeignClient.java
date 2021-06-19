package com.vsemployeedetails.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("orders-details")
public interface OrderFeignClient {

  @GetMapping("/orders/{employeeId}")
  String fetchOrderByEmployeeId(@PathVariable("employeeId") String employeeId);
}
