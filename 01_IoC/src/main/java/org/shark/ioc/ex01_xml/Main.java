package org.shark.ioc.ex01_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

  public static void main(String[] args) {

    // XML을 이용해 등록한 빈 관리는 GenericXMLApplicationContext 클래스를 이용합니다.
    
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("ex01_xml/appContext.xml");
    
    // Spring Container에 등록한 빈이 singleton인지 확인합니다.
    Adder add1 = ctx.getBean("add", Adder.class);
    Adder add2 = ctx.getBean("add", Adder.class);
    System.out.println(add1 == add2);  // true

  }

}
