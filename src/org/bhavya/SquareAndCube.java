package org.bhavya;


import static java.lang.Math.sqrt;
import static java.lang.Math.cbrt;

public class SquareAndCube {

  public static void main(String[] args) {
    System.out.println(operations(8765));
  }

  //accept 4 digit number
  // square root of that bnumber
  // cuberoot of the number
  // reverse

  private static Integer operations(Integer num){
    squareRoot(num);
    cubeRoot(num);
    return reverse(num);
  }

  private static void squareRoot(Integer num){
    System.out.println(sqrt(num));
  }

  private static void cubeRoot(Integer num) {
    System.out.println(cbrt(num));
  }

  private static Integer reverse(Integer num) {
    var i = 0;
    var reverse = "";
    while(num > 0) {
      var mod10 = num % 10;     //5   // 6
      reverse = reverse + mod10;
      num = num/10;
    }
    return Integer.parseInt(reverse);
  }



}
