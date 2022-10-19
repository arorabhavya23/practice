package org.bhavya.practice;

//https://www.hackerrank.com/challenges/angry-children/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms


import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

public class MinMax {

  public static int maxMin(int k, List<Integer> arr) {
    // Write your code here
    arr = arr.stream().sorted().collect(toList());
    int min = arr.get(0);
    int max = arr.get(k - 1);
    int diff = max - min;
    System.out.println(arr);
    if (arr.contains(arr.get(k - 1) + 1463)) {
      System.out.println();
    }
    k--;
    for (int i = k; i < arr.size(); i++) {
      if (arr.contains(arr.get(i) + 1463)) {
        System.out.println("Location is " + i);
        System.out.println("value is " + arr.get(i));
        System.out.println("location is " + arr.indexOf(arr.get(i) + 1463));
      }
      diff = Math.min(diff, (arr.get(i) - arr.get(i - k)));
    }
    return diff;

  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int k = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
          try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    int result = maxMin(k, arr);
    System.out.println(result);

    bufferedReader.close();
  }

}
