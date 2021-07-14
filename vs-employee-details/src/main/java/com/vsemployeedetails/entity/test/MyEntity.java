package com.vsemployeedetails.entity.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "x_entity")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MyEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "x_static_field")
  private static int staticField;

  @Column(name = "x_final_field")
  private final int transient2 = 20;

  private transient int transient3;

  @Transient
  private int transient4;

  private String name;

  @OneToMany(mappedBy = "myEntity")
  private Set<MyEntityDetails> detailsList;

}
