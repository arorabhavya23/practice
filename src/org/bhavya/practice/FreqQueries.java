package org.bhavya.practice;

//https://www.hackerrank.com/challenges/frequency-queries/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FreqQueries {

  static List<Integer> freqQuery(List<List<Integer>> queries) {
    Map<Integer, Integer> freqMap = new TreeMap<>();
    List<Integer> ans = new ArrayList<>();
    Integer max = 0;
    for (List<Integer> e : queries) {
      Integer a = e.get(0);
      Integer b = e.get(1);
      switch (a) {
        case 1: {
          freqMap.put(b, freqMap.getOrDefault(b, 0) + 1);
          max = Math.max(freqMap.get(b), max);
          break;
        }
        case 2: {
          if (freqMap.containsKey(b) && freqMap.get(b) > 0) {
            freqMap.put(b, freqMap.get(b) - 1);
          }
          break;
        }
        case 3: {
          if (max >= b && freqMap.containsValue(b)) {
            ans.add(1);
          } else {
            ans.add(0);
          }
          break;
        }
      }

    }
    return ans;

  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\arora\\projects\\practice\\src\\org\\bhavya\\practice\\input.txt"));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, q).forEach(i -> {
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

    System.out.println("Input Complete");

    List<Integer> ans = freqQuery(queries);
    List<Integer> ans1 = new ArrayList<>();




//    System.out.println(ans);

    IntStream.range(0, ans.size()).forEach(i -> {
      try {
        ans1.add(Integer.parseInt(bufferedReader.readLine().trim()));;
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    System.out.println(ans1.size() == ans.size());
    for (int i = 0; i < ans.size(); i++) {
      if(!ans.get(i).equals(ans1.get(i))){
        System.out.println("index is "+ i + " expected value is " + ans1.get(i) + " actual value is  " + ans.get(i) + " query is ");
      }
    }

    bufferedReader.close();
  }
}
