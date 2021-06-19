package com.vsemployeedetails.service;

import com.vsemployeedetails.dto.EmployeeDTO;
import com.vsemployeedetails.dto.EmployeeDetailsDTO;
import com.vsemployeedetails.entity.Employee;
import com.vsemployeedetails.entity.EmployeeDetails;
import com.vsemployeedetails.repository.EmployeeDetailsRepository;
import com.vsemployeedetails.repository.EmployeeRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private EmployeeDetailsRepository employeeDetailsRepository;

  @Autowired
  private ModelMapper modelMapper;


  @Override
  public Employee save(EmployeeDTO employeeDTO) {
    final Employee employee = convertDtoToEntity(employeeDTO);
    final Employee save = employeeRepository.save(employee);
    log.info("Saved Employee {} ", save);
    return save;

  }

  private Employee convertDtoToEntity(EmployeeDTO employeeDTO) {
    log.info("convertDtoToEntity {} ");
    final EmployeeDetailsDTO employee_details = employeeDTO.getEmployee_details();
    final Employee map = modelMapper.map(employeeDTO, Employee.class);
    final EmployeeDetails employeeDetails = modelMapper.map(employee_details, EmployeeDetails.class);
    employeeDetailsRepository.save(employeeDetails);
    map.setEmployeeDetails(employeeDetails);
    return map;
  }

  @Override
  public Optional<Employee> findById(Integer id) {
    return Optional.ofNullable(employeeRepository.findById(id))
        .orElseThrow(() -> new RuntimeException("No Employee Found "));
  }


  @Override
  public List<Employee> findAll() {
    return Optional.ofNullable(employeeRepository.findAll()).orElse(Collections.emptyList());
  }

  @Override
  public List<Employee> fetchAllEmployeeDetails() {
    log.info("Fetch All Employee ");
    return Optional.ofNullable(employeeRepository.fetchAll()).orElse(Collections.emptyList());
  }



  @Override
  public String getAllEmployeeOrder(String employeeId) {
    return null;
  }
}
