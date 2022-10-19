package org.bhavya.practice;

import java.security.spec.ECField;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.bhavya.mcq.parentUtil;

public class ChildUtil extends Thread {

  ChildUtil() {
  }

  ChildUtil(Runnable r) {
    super(r);
  }

  public void run() {

    System.out.print("Inside Thread ");

  }

}

class MyRunnable implements Runnable {

  public void run() {
    System.out.print(" Inside Runnable");

//    fuckemank.com/test/ejts/388qaz/questions/AXMEM

  }
}

  class Test {

    public static void main(String[] args) {

//      new ChildUtil().start();
//
//      new ChildUtil(new MyRunnable()).start();
      drink d = new drink();
      drink d1 = new drink();
      d.setName("name");
      d1.setName("age");

      Set ts = new TreeSet<drink>();
      ts.add(d);
      ts.add(d);
      System.out.println(Arrays.toString(ts.toArray()));
      ts.stream().peek(o -> System.out.println(o.toString()));
    }
  }


  class drink implements Comparable {

//    @Override
    public int compareTo(Object o) {
      return 0;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getAge() {
      return age;
    }

    public void setAge(String age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return "drink{" +
          "name='" + name + '\'' +
          ", age='" + age + '\'' +
          '}';
    }

    String name;
    String age;
  }