package org.bhavya.NPTEL.Java;

import static java.lang.Math.max;

import java.util.HashMap;

/**
 * Write a program which will print a pyramid of "*" 's of height "n" and print the number of "*" 's in the pyramid.
 *
 * For example:
 *
 * Input : 5
 * Output:
 *
 *         *
 *       * * *
 *     * * * * *
 *   * * * * * * *
 * * * * * * * * * *
 *
 *          *
 *        * * *
 *      * * * * *
 *    * * * * * * *
 *  * * * * * * * * *
 * 25
 */
public class Week8Assignment1 {

  public static void main(String[] args) {
//    buildStarPyramid(5);
//    buildStarPyramidInverted(7);
    sevenSegmentDisplay(0);
    sevenSegmentDisplay(1);
    sevenSegmentDisplay(2);
    sevenSegmentDisplay(3);
    sevenSegmentDisplay(4);
    sevenSegmentDisplay(5);
    sevenSegmentDisplay(6);
    sevenSegmentDisplay(7);
    sevenSegmentDisplay(8);
    sevenSegmentDisplay(9);
  }

  public static void buildStarPyramid(int l) {
    int sum = 0;
    for (int i = 0; i < l; i++) {
      StringBuilder s = new StringBuilder();
      for (int j = i+1; j < l; j++) {
        s.append("  ");
      }
      int j = 0,k = 0;
      for (; j <=i ; j++) {
        s.append(++k).append(" ").append(++k).append(" ");
        sum+=k;
        sum+=k;
        sum--;
      }
//      System.out.println();
      sum-=k;
      System.out.println(s.substring(0,(l*2)+(i*2)));
    }
    System.out.println(sum);
  }

  public static void buildStarPyramidInverted(int l) {
    StringBuilder res = new StringBuilder();
    StringBuilder res1 = new StringBuilder();
    l= l/2;
    l++;
    for (int i = 0; i < l; i++) {
      StringBuilder s = new StringBuilder();
      for (int j = i+1; j < l; j++) {
        s.append(" ");
      }
      for (int j = 0; j <=i ; j++) {
        s.append("* ");
      }

      res.append(s).append("\n");
    }
    for (int i = l-1; i >0; i--) {
      StringBuilder s = new StringBuilder();
      for (int j = i; j < l; j++) {
        s.append(" ");
      }
      for (int j = 0; j <i ; j++) {
        s.append("* ");
      }

      res.append(s).append("\n");
    }
    System.out.println(res);
//    System.out.println(res.reverse());
  }


  private static void sevenSegmentDisplay(int n){
    System.out.println("   ");
    String example= " _     _  _     _  _  _  _  _ \n| |  | _| _||_||_ |_   ||_||_| \n|_|  ||_  _|  | _||_|  ||_| _|";
    HashMap<Integer, String> map = new HashMap<>();
    map.put(0, " _\n| |\n|_|"); // 00111111
    map.put(1, "  \n  |\n  |"); // 00000110
    map.put(2, " _\n _|\n|_ "); // 01011011
    map.put(3, " _\n _|\n _|"); // 01001111
    map.put(4, "  \n|_|\n  |"); // 01100110
    map.put(5, " _\n|_ \n _|"); // 01101101
    map.put(6, " _\n|_\n|_|"); // 01111101
    map.put(7, " _\n  |\n  |"); // 00000111
    map.put(8, " _\n|_|\n|_|"); // 01111111
    map.put(9, " _\n|_|\n _|"); // 01101111
    System.out.println(map.get(n));
//    System.out.println(example);
  }

}
