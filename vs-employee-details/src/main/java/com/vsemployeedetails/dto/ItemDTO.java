package com.vsemployeedetails.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ItemDTO {
  private Integer itemId;
  private String itemName;
  private String itemDescription;
  private Double itemPrice;
}
