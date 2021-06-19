package com.vsemployeedetails.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO {

  private Integer id;

  private String name;

  private String email;

  private String employeeId;

  private EmployeeDetailsDTO employee_details;

}
