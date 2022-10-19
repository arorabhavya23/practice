package org.bhavya.mcq;



public class MyClass {

  public static void main(String[] args) {
    System.out.println("hello from class");
    System.out.println("calling interface " );
    testClass tc = new testClass();
    tc.print();
    System.out.println("finished");

  }

}

class testClass implements One, Two {

}
