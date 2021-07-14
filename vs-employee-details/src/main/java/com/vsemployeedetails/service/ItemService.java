package com.vsemployeedetails.service;

import com.vsemployeedetails.entity.Item;

import java.util.List;
import java.util.stream.Stream;

public interface ItemService {

  List<Item> itemPriceMoreThan(Double price);

  List<Item> itemPriceLessThan(Double price);

  List<Item> itemWithDescription(String description);

  void saveItem(Item item);

  void saveItems(List<Item> items);

  List<Item> findAllItems();
}
