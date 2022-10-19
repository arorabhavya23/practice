package org.bhavya.practice;

import static java.util.List.of;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JarCokkies {

  /*[12:02 PM] Vineeth Vijayan
    [10 20 30 90 60]
    //max of the
    [10 90 20 30 60]

    150


    1
    121
    12321
    1234321
   */

  static void printPatter(int height) {
    StringBuilder pattern = new StringBuilder();
    StringBuilder patternrev = new StringBuilder();
    for (int i = 1; i <= height; i++) {
      // add i to pattern               1   12      123         1234
      // print pattern + rev pattern    1   121     12321       1234321
      // add i to rev pattern           1   21      321         4321

      pattern.append(i);
      System.out.println(pattern.toString() + patternrev);
      patternrev.insert(0, i);
    }
  }

 /*
     [10 20 30 90 60]
         //max of the
     [10 90 20 30 60]
  */
  static Integer getMaxOfSecond(List<Integer> myList) {
    var sum = 0;
    for (int i = 0; i < myList.size() - 2; i+= 2) {
      if(sum + myList.get(i) < sum + myList.get(i+1) && sum + myList.get(i) + myList.get(i+2) < sum + myList.get(i+1)){
        sum += myList.get(i+1);
        i++;
      } else {
        sum += myList.get(i);
      }
    }
    var sumEven = 0;
    var sumOdd = 0;
    for (int i = 0; i < myList.size(); i++) {
     if(i%2 == 0){
       sumEven += myList.get(i);
     } else {
       sumOdd += myList.get(i);
     }
    }
    var sumrev = 0;
    for (int i = myList.size()-1; i > 1 ; i-= 2) {
      if(sumrev + myList.get(i) < sumrev + myList.get(i-1)&& sum + myList.get(i) + myList.get(i-2) < sum + myList.get(i-1)){
        sumrev += myList.get(i-1);
        i--;
      } else {
        sumrev += myList.get(i);
      }
    }
    return Math.max(sum, Math.max(sumrev, Math.max(sumEven, sumOdd)));
  }

  public static void main(String[] args) {
//    printPatter(4);
//    printPatter(10);

//    Scanner sc = new Scanner(System.in);
//    var a = sc.nextInt();
//    var b = sc.nextLine();
//    var arrs = b.split(" ");
//    List<Integer> inpList = new ArrayList<>();
//    for (String arr : arrs) {
//      inpList.add(Integer.valueOf(arr));
//    }
//    var result = getMaxOfSecond(inpList);
//    System.out.println(result);
//    System.out.println(getMaxOfSecond(of(10, 20, 30, 90, 60)));
    System.out.println(getMaxOfSecond(of(2, 1, 5, 8, 4)));
  }


}
