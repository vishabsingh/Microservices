package com.vsemployeedetails.repository.jpaspecification;

import com.vsemployeedetails.entity.Item;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepositorySpecification extends CrudRepository<Item,Integer>, JpaSpecificationExecutor {

}
