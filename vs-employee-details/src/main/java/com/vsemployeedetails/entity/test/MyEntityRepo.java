package com.vsemployeedetails.entity.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRepo extends JpaRepository<MyEntity,Integer> {
}
