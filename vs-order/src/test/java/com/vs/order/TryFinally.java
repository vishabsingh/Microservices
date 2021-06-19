package com.vs.order;

public class TryFinally {
  public static void main(String[] args) {
    System.out.println(method());
  }

  private static int method() {
    try {
      int j = 10/0;
      return 1;
    } catch (Exception e) {
      return 2;
    } finally {
      return 3;
    }
  }
}
