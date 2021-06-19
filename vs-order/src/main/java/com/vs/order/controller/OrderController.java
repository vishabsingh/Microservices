package com.vs.order.controller;

import com.vs.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/{employeeId}")
  public String fetchOrderByEmployeeId(@PathVariable("employeeId") String employeeId) {
    return orderService.findByEmployeeId(employeeId);
  }
}
