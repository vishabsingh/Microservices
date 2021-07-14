package com.vsemployeedetails.repository.jpaspecification.specs;

import com.vsemployeedetails.entity.Item;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class ItemSpecification implements Specification<Item> {

  @Override
  public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    return null;
  }
}
