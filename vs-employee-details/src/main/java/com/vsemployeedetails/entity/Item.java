package com.vsemployeedetails.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.StringJoiner;

@Entity
@Table(name = "Item")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Item implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer itemId;
  private String itemName;
  private String itemDescription;
  private Double itemPrice;

  public Item(String itemName, String itemDescription, Double itemPrice) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
    this.itemPrice = itemPrice;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
        .add("itemId=" + itemId)
        .add("itemName='" + itemName + "'")
        .add("itemDescription='" + itemDescription + "'")
        .add("itemPrice=" + itemPrice)
        .toString();
  }
}
