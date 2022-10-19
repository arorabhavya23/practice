package org.bhavya.practice;
//  https://www.hackerrank.com/challenges/two-strings/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoStrings {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        String result = twoStrings(s1, s2);

      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }

  public static String twoStrings(String s1, String s2) {
    // Write your code here
    Set<Character> set1 = new HashSet<>();
    for (int i = 0; i < s1.length(); i++) {
      set1.add(s1.charAt(i));
    }
    for (int i = 0; i < s1.length(); i++) {
      if(! set1.contains(s2.charAt(i))){
        return "NO";
      }
    }
    return "YES";

  }

}
