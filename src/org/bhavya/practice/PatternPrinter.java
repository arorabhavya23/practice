package org.bhavya.practice;


import java.util.Scanner;

/**
 printpattern(int n)
 
 n=5
     1
    121
   12321
  1234321
 123454321
 1234321 ---> 6 len-> 7 = 4*2-1
 12321
 121
 1

 */
public class PatternPrinter {

  private static String b = "yash";

  private static void printpattern(int n){
    // loop for hight n*2-1
    // length of a sting is hight*2 -1 and print this lenth elemets
    // loop from 1 to hight then hight to 0;
    for (int height = 1; height < (n*2); height++) {
      var spaces = n >= height ? (n-height) : (height-n);
//      var stringLen = n >= height ? (n - (n-height)) : n - (height-n);
      var stringLen = n-spaces;
//
      int i = 0;
      for (int j = 0; j < spaces; j++) {
        System.out.print(" ");
      }
      for (; i < stringLen; i++) {
        System.out.print(i+1);
      }
//      stringLen = (stringLen * 2) -1;
      i--;
      for (; i > 0; i--) {
        System.out.print(i);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
//    printpattern(3);
//    Integer x = 100;
//    Integer y = 100;
//    System.out.println("100 == 100 : -> " + (x == y));                 //  true
//    System.out.println("100.equals(100) : -> " + x.equals(y));            //  true
//
//    System.out.println("________________________________________________________________________");
//    Integer c = 500;
//    Integer d = 500;
//    System.out.println("500 == 500 : -> " + (c == d));                 //  true
//    System.out.println("500.equals(500) : -> " + c.equals(d));

    some s = new some();
    s.display(new String("yash"));

  }



}
