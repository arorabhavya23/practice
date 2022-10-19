package org.bhavya;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // write your code here
    System.out.println("hello  World!!");
    System.out.println(primeNumbers(100));
    System.out.println(vanHoc(10));
  }

  private static List<Integer> primeNumbers(Integer num) {
    var primes = new ArrayList<Integer>();
    for (int i = 2; i < num; i++) {
      var flag = true;
      for (int j = 2; j <= i / 2; j++) {
        if (i % j == 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        primes.add(i);
      }
    }
    Integer loc = primes.lastIndexOf(39);
    return primes;
  }

  //0, 0, 1, 0, 2, 0, 2, 2, 1, 6, 0, 5, 0, 2, 6, 5, 4, 0, 5, 3, 0, 3, 2, 9 ...
  private static List<Integer> vanHoc(Integer count) {
    var start = 0;
    var sequence = new ArrayList<Integer>();
    sequence.add(0);                                    // 0
    while (sequence.size() < count) {
      if (sequence.subList(0, sequence.size() - 1).contains(start)) {
        var loc = sequence.subList(0, sequence.size() - 1).lastIndexOf(start) + 1; // 1 // 2
        start = sequence.size() - loc;  // 0    // 0
        sequence.add(start);    // 0 0
      } else {
        sequence.add(0);
        start = 0;
      }


    }
    return sequence;
  }
}
