package com.vs.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vs.order.entity.MyOrder;
import com.vs.order.repository.OrderRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements  OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public void saveOrder(MyOrder order) {
    orderRepository.save(order);
    log.debug("Order is saved ......");
  }

  @Override
  public String findByEmployeeId(String employeeId) {
    final List<MyOrder> byEmployeeId = orderRepository.findByEmployeeId(employeeId);
    log.info("Result Of Order {}",byEmployeeId);
    Map<String,Object> map = new HashMap<>();
    map.put("orders",byEmployeeId);
    final ObjectMapper objectMapper = new ObjectMapper();
    try {
      final String string = objectMapper.writeValueAsString(map);
      return string;
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Not able to parse");
    }
  }
}
