package com.vsemployeedetails.repository;

import com.vsemployeedetails.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {

  @Query("SELECT emp FROM Employee emp JOIN emp.employeeDetails empDetails")
  List<Employee> fetchAll() ;

}
