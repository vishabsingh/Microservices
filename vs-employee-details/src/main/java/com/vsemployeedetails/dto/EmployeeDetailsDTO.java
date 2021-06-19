package com.vsemployeedetails.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class EmployeeDetailsDTO {

  private Integer id;

  private String state;

  private String phoneNumber;

  private String gender;

  private Date dateOfBirth;

  private String street;

  private String zipCode;

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    if (StringUtils.isNotBlank(dateOfBirth)) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
      final LocalDate parse = LocalDate.parse(dateOfBirth, formatter);
      this.dateOfBirth = Date.from(parse.atStartOfDay(ZoneId.systemDefault()).toInstant());;
    }
  }
}
