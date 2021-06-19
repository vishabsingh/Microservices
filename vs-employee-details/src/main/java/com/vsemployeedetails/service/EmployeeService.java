package com.vsemployeedetails.service;

import com.vsemployeedetails.dto.EmployeeDTO;
import com.vsemployeedetails.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

  Employee save(EmployeeDTO employee);

  Optional<Employee> findById(Integer id);

  List<Employee> findAll();

  List<Employee> fetchAllEmployeeDetails();

  String getAllEmployeeOrder(String employeeId);

}
