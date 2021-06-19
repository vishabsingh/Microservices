package com.vs.order.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test {
  public static void main(String[] args) {
    Map<Employee, String> myMap = new HashMap<>();
    myMap.put(new Employee("ABC"), "value1");
    myMap.put(new Employee("XYZ"), "value2");
    myMap.put(new Employee("ABC"), "value3");
    System.out.println(myMap.size());
  }
}

class Employee {

  private String name;
  public Employee(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(name, employee.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}

