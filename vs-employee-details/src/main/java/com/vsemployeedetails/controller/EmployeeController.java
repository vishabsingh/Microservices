package com.vsemployeedetails.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsemployeedetails.dto.EmployeeDTO;
import com.vsemployeedetails.entity.Employee;
import com.vsemployeedetails.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private ObjectMapper objectMapper;

  @PostMapping("/save")
  public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDTO request) {
    final Employee save = employeeService.save(request);
    return new ResponseEntity<>(save, HttpStatus.CREATED);

  }

  @GetMapping("/fetchAllEmployee")
  public List<Employee> getEmployee() {
    return employeeService.findAll();
  }

  @GetMapping("/fetchAllDetails")
  public List<Employee> getEmployeeDetails() {
    return employeeService.fetchAllEmployeeDetails();
  }

  @GetMapping("/orderDetails/{employeeId}")
  public String fetchAllEmployeeWithOrderDetails(@PathVariable String employeeId){
    return employeeService.getAllEmployeeOrder(employeeId);
  }
}
