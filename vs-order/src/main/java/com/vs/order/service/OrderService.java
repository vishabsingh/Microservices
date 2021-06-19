package com.vs.order.service;

import com.vs.order.entity.MyOrder;

public interface OrderService {
  void saveOrder(MyOrder order);

  String findByEmployeeId(String employeeId);
}
