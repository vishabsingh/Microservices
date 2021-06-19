package com.vs.order;

class Test {

  private static Test TEST = null;

  private Test() {

  }

  public static Test getInstance() {
    synchronized (Test.class) {
      if (TEST == null) {
        TEST = new Test();
      }
      return TEST;
    }
  }
}
