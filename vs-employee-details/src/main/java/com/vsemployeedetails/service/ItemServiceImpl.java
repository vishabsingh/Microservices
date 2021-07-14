package com.vsemployeedetails.service;

import com.netflix.discovery.converters.Auto;
import com.vsemployeedetails.entity.Item;
import com.vsemployeedetails.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemRepository itemRepository;

  @Override
  public List<Item> itemPriceMoreThan(Double price) {
    return itemRepository.itemPriceMoreThan(price);
  }

  @Override
  public List<Item> itemPriceLessThan(Double price) {
    return itemRepository.itemPriceLessThan(price);
  }

  @Override
  public List<Item> itemWithDescription(String description) {
    return itemRepository.itemWithDescription(description);
  }

  @Override
  public void saveItem(Item item){
    itemRepository.save(item);
  }

  @Override
  public void saveItems(List<Item> items) {
    itemRepository.saveAll(items);
  }

  @Override
  public List<Item> findAllItems() {
    return itemRepository.findAll();
  }
}
