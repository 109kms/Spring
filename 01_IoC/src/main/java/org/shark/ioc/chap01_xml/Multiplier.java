package org.shark.ioc.chap01_xml;

public class Multiplier {

  public int multiply(int... args) {
    int total = 1;
    if (args == null) {
      return 0;
    }
    for (int i = 0; i < args.length; i++) {
      total *= args[i];
    }
    return total;
  }

}
