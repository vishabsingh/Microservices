package com.vsemployeedetails.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "xEmployeeDetails")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails  implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String state;

  @Column(name = "phone_number")
  @Size(max = 15)
  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  @Column(length = 10)
  private Gender gender;

  @Temporal(TemporalType.DATE)
  private Date dateOfBirth;

  @Size(max = 100)
  private String street;

  @Column(name = "zip_code")
  @Size(max = 32)
  private String zipCode;

  @OneToOne(cascade = CascadeType.ALL)
  private Employee employee;

  public EmployeeDetails(String state, Gender gender, String zipCode) {
    this.state = state;
    this.gender = gender;
    this.zipCode = zipCode;
  }
}
