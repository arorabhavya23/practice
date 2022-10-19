package org.bhavya.practice;
//https://www.hackerrank.com/challenges/mark-and-toys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class MarkAndToys {

  public static int maximumToys(List<Integer> prices, int k) {
    // Write your code here
    int sum = 0;
    prices = prices.stream().sorted().collect(toList());
//    System.out.println(prices);
    for (int i = 0; i < prices.size(); i++) {
//      System.out.println(sum);

      sum += prices.get(i);
      if(sum > k){

        return i;
      }
    }
    return prices.size()-1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = maximumToys(prices, k);

    System.out.println(result);

    bufferedReader.close();
  }

}
