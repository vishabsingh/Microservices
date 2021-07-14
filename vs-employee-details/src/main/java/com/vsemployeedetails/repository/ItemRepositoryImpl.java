package com.vsemployeedetails.repository;

import com.vsemployeedetails.entity.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepositoryCustom{

  public static final String ITEM_PRICE = "itemPrice";
  public static final String ITEM_DESCRIPTION = "itemDescription";

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Item> itemPriceMoreThan(Double price) {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    final CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Item.class);
    Root<Item> root = criteriaQuery.from(Item.class);
    criteriaQuery.select(root).where(criteriaBuilder.gt(root.get(ITEM_PRICE),price));
    TypedQuery<Item> typedQuery = entityManager.createQuery(criteriaQuery);
    return typedQuery.getResultList();
  }

  @Override
  public List<Item> itemPriceLessThan(Double price) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Item> query = builder.createQuery(Item.class);
    Root<Item> root = query.from(Item.class);
    query.select(root).where(builder.lessThan(root.get(ITEM_PRICE),price));
    return entityManager.createQuery(query).getResultList();
  }

  @Override
  public List<Item> itemWithDescription(String description) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Item> query = criteriaBuilder.createQuery(Item.class);
    Root<Item> root = query.from(Item.class);
    query.select(root).where(criteriaBuilder.like(root.get(ITEM_DESCRIPTION),description));
    return entityManager.createQuery(query).getResultList();
  }
}
