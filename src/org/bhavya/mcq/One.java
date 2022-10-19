package org.bhavya.mcq;

public interface One {

  int a = 5;
  default void print(){
    System.out.println("hello from one");
  }

}
