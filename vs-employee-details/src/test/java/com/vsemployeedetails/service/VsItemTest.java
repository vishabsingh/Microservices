package com.vsemployeedetails.service;

import com.vsemployeedetails.entity.Item;
import com.vsemployeedetails.repository.ItemRepository;
import com.vsemployeedetails.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class VsItemTest {

  @Autowired
  private ItemService itemService;

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private EntityManager entityManager;

  @BeforeEach
  public void setUp() {
    Item item1 = new Item("Laptop","Dell-Inspiron15",41000.67);
    Item item2 = new Item("Laptop","HP-Notebook",50000.45);
    Item item4 = new Item("Laptop","HP-Notebook",70000.788);
    Item item3 = new Item("Desktop","MAC",60000.78);
    Item item5 = new Item("Server","MAC-Server",340000.78);
    final List<Item> items = Arrays.asList(item1, item2, item3,item4,item5);
    itemService.saveItems(items);
  }

  @Test
  public void findAllTest() {
    final List<Item> allItems = itemService.findAllItems();
    log.info("Find All Items {} : " ,allItems);
    Assertions.assertThat(allItems)
        .isNotEmpty()
        .hasSize(5);
  }

  @Test
  public void findItemMoreThan() {
    final List<Item> items = itemService.itemPriceMoreThan(50000d);
    log.info("Result {} ",items);
    Assertions.assertThat(items)
        .isNotEmpty()
        .hasSize(4);
  }

  @Test
  public void findItemLessThan() {
    final List<Item> items = itemService.itemPriceLessThan(50000d);
    log.info("Find Item Less Than {} ",items);
    Assertions.assertThat(items)
        .isNotEmpty()
        .hasSize(1);
  }

  @Test
  public void itemWithDescriptionTest() {
    final List<Item> items = itemService.itemWithDescription("MAC");
    log.info("Items {} ",items);
    final Map<String, List<Item>> collect = items
        .stream()
        .filter(Objects::nonNull)
        .collect(Collectors.groupingBy(Item::getItemDescription));
    log.info("Item With DescriptionTest {} ",collect);
  }

  @Test
  public void fetchItemsWithAllTest () {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Item> query = criteriaBuilder.createQuery(Item.class);
    Root<Item> root = query.from(Item.class);
    query
        .select(root)
        .where(criteriaBuilder.like(root.get("itemDescription"),"%MAC%"));
    final List<Item> itemDesWithMac = entityManager.createQuery(query).getResultList();
    log.info("Fetch  All Items With Mac Description {} ",itemDesWithMac);
  }

  @Test
  public void fetchItemsInTest() {
    final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Item> query = criteriaBuilder.createQuery(Item.class);
    Root<Item> root = query.from(Item.class);
    query.select(root)
        .where(root.get("itemName").in("Desktop","Server"));
    System.out.println("Desktop And Server {} : "+ entityManager.createQuery(query).getResultList());
  }

  @AfterEach
  void teardown() {
    log.info("teardown");
    itemRepository.deleteAllInBatch();
  }


}
