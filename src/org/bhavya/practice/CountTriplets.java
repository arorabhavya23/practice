package org.bhavya.practice;

//https://www.hackerrank.com/challenges/count-triplets-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class CountTriplets {

  static long countTriplets(List<Long> arr, long r) {
    Map<Long, Long> potential = new HashMap<>();
    Map<Long, Long> counter = new HashMap<>();
    long count = 0;
    for (int i = 0; i < arr.size(); i++) {
      long a = arr.get(i);
      long key = a / r;

      if (counter.containsKey(key) && a % r == 0) {
        count += counter.get(key);
      }

      if (potential.containsKey(key) && a % r == 0) {
        long c = potential.get(key);
        counter.put(a, counter.getOrDefault(a, 0L) + c);
      }

      potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(nr[0]);

    long r = Long.parseLong(nr[1]);

    List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Long::parseLong)
        .collect(toList());

    long ans = countTriplets(arr, r);
    System.out.println(ans);

    bufferedReader.close();
  }

}
