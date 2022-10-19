package org.bhavya;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'bigSorting' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY unsorted as parameter.
   */

  public static List<String> bigSorting(List<String> unsorted) {
    // Write your code here

//    return unsorted.stream().sorted(Comparator.comparingInt(String::length).thenComparingLong(Long::parseUnsignedLong)).collect(toList());
    return unsorted.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Double::parseDouble)).collect(toList());
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
          try {
            return bufferedReader.readLine();
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .collect(toList());

    List<String> result = Result.bigSorting(unsorted);
    System.out.println(result);

//    bufferedWriter.write(
//        result.stream()
//            .collect(joining("\n"))
//            + "\n"
//    );

    bufferedReader.close();
//    bufferedWriter.close();
  }
}

/*
10
4
2
3
1
100
12303479849857341718340192371
3084193741082937
3084193741082938
111
200
 */