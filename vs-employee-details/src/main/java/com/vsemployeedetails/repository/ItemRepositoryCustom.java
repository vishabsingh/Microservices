package com.vsemployeedetails.repository;

import com.vsemployeedetails.entity.Item;

import java.util.List;

public interface ItemRepositoryCustom {
  List<Item> itemPriceMoreThan(Double price);

  List<Item> itemPriceLessThan(Double price);

  List<Item> itemWithDescription(String description);
}
