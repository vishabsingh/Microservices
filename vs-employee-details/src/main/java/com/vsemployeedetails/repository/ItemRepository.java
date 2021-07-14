package com.vsemployeedetails.repository;

import com.vsemployeedetails.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer>, ItemRepositoryCustom {

}
