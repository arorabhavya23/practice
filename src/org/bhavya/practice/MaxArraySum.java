package org.bhavya.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxArraySum {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc = new Scanner(System.in);
    var a = sc.nextLine();
    var b = sc.nextLine();

    var arrs = b.split(" ");
    List<Integer> inpList = new ArrayList<>();
    for (String arr : arrs) {
      inpList.add(Integer.valueOf(arr));
    }
    var result = getMaxOfSecond(inpList);
    System.out.println(result);
  }

  static Integer getMaxOfSecond(List<Integer> myList) {
    var sum = 0;
    var sumEven = 0;
    var sumOdd = 0;
    for (int i = 0; i < myList.size(); i++) {
      if (i % 2 == 0) {
        sumEven += myList.get(i) > 0 ? myList.get(i) : 0;
      } else {
        sumOdd += myList.get(i) > 0 ? myList.get(i) : 0;
      }
    }
    return Math.max(sum, Math.max(sumEven, sumOdd));
  }

}
