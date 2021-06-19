package com.vsemployeedetails.repository;

import com.vsemployeedetails.entity.EmployeeDetails;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails,Integer> {

  @Query(value = "select new com.vsemployeedetails.entity.EmployeeDetails(emp.state,emp.gender,emp.zipCode) from EmployeeDetails emp")
  List<EmployeeDetails> findAllEmployeeSortByName(Pageable pageable);

}
