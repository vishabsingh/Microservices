package com.vsemployeedetails.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "xEmployee")
@Setter
@Getter
@NoArgsConstructor
public class Employee  implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "xName")
  private String name;

  @Column(name = "xEmail")
  private String email;

  private String employeeId;

  @OneToOne(mappedBy = "employee",fetch =  FetchType.EAGER)
  private EmployeeDetails employeeDetails;
}
