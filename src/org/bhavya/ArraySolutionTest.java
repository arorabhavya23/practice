package org.bhavya;

//array  1-6 2 ,3 ,4,5,6,2
//

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * duplicate value and missing number in sequence
 */
public class ArraySolutionTest {

  //would find the last duplicate and return the same

  private static void findDuplicatesAndMissing(List<Integer> arrList) {

    Integer mis = arrList.stream().sorted().reduce((integer, integer2) -> {
      System.out.print(integer2 + " - ");
      System.out.print(integer + " = ");
      System.out.println(integer2 - integer > 1 ? integer2 - 1 : -1);
      if (integer2 != 0
      ) {

        return integer2 - integer > 1 ? integer2 - 1 : -1;
      }
      return integer;
    }).orElse(-1);
    Integer dup = arrList.stream().filter(x -> Collections.frequency(arrList, x) > 1).findFirst()
        .orElse(-1);

    System.out.println("Duplicate number is " + dup);
    System.out.println("Missing number is " + mis);
  }

  public static void main(String[] args) {

    findDuplicatesAndMissing(Arrays.asList(2, 1, 4, 5, 6, 2));
  }


}
