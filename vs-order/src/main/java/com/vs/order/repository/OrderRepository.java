package com.vs.order.repository;

import com.vs.order.entity.MyOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder, Integer> {
  List<MyOrder> findByEmployeeId(String employeeId);
}
