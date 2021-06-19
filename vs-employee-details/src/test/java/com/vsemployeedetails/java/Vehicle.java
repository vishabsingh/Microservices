package com.vsemployeedetails.java;

public interface Vehicle {
  String getBrand();

  String speedUp();

  String slowDown();

  default String turnAlarmOn() {
    return "Turning the vehicle alarm on.";
  }

  default String turnAlarmOff() {
    return "Turning the vehicle alarm off.";
  }
}
