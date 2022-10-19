package org.bhavya.practice;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayManipulation {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, m).forEach(i -> {
      try {
        queries.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    long result = arrayManipulation(n, queries);
    System.out.println(result);

    bufferedReader.close();
  }

  public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here
    long[] myArr = new long[1+n];
    long ans = 0L;
    long sum = 0L;
    for (List<Integer> integers : queries) {
     myArr[integers.get(0)] += integers.get(2);
     myArr[integers.get(1)+1] -= integers.get(2);
    }
    for(long l : myArr){
      sum += l;
      if(sum > ans){
        ans = sum;
      }
    }
    return ans;
  }
}

/*
10 4
2 6 8
3 5 7
1 8 1
5 9 15
 */
