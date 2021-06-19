package com.vsemployeedetails.java;

public class Car implements Vehicle , Alarm{
  @Override
  public String getBrand() {
    return "BMW";
  }

  @Override
  public String speedUp() {
    return "150";
  }

  @Override
  public String slowDown() {
    return "20";
  }

  @Override
  public String turnAlarmOn() {
    return Vehicle.super.turnAlarmOn();
  }

  @Override
  public String turnAlarmOff() {
    return Vehicle.super.turnAlarmOff();
  }

  public static void main(String[] args) {
    Vehicle car = new Car();
    System.out.println(car.getBrand());
    System.out.println(car.speedUp());
    System.out.println(car.slowDown());
    System.out.println(car.turnAlarmOn());
    System.out.println(car.turnAlarmOff());
  }
}
