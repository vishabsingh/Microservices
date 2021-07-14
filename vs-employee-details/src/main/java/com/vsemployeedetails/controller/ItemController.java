package com.vsemployeedetails.controller;

import com.vsemployeedetails.entity.Item;
import com.vsemployeedetails.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

  @Autowired
  private ItemService itemService;

  @PostMapping("/item")
  public ResponseEntity<Item> saveItem(@RequestBody Item request) {
    itemService.saveItem(request);
    return new ResponseEntity("OK", HttpStatus.CREATED);

  }

  @PostMapping("/items")
  public ResponseEntity<Item> saveItems(@RequestBody List<Item> request) {
    itemService.saveItems(request);
    return new ResponseEntity("OK", HttpStatus.CREATED);

  }

  @GetMapping("/fetchAllItems")
  public List<Item> findAllItems() {
    return itemService.findAllItems();
  }
}

