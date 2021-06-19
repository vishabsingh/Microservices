package com.vsemployeedetails.java;

import com.vsemployeedetails.entity.Employee;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//public class Diamond implements Diamond.Interface1,Diamond.Interface2 {
public class Diamond {

  interface Interface1 {
    default public void foo() { System.out.println("Interface1's foo"); }
  }
  interface Interface2 {
    default public void foo() { System.out.println("Interface2's foo"); }
  }

  interface A {
    default void foo() { System.out.println("hello from A"); }
  }

  interface B extends A {
    default void foo() { System.out.println("hello from B"); }
  }

  interface C extends A {}

  static class D implements B, C {

  }

  public static void main(String[] args) {
    C c = new D();
    c.foo();
  }
}


