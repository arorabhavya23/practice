package org.bhavya.practice;

//  https://www.hackerrank.com/challenges/ctci-ransom-note/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class HashTablesRansomNote {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int m = Integer.parseInt(firstMultipleInput[0]);

    int n = Integer.parseInt(firstMultipleInput[1]);

    List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .collect(toList());

    List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .collect(toList());

    checkMagazine(magazine, note);

    bufferedReader.close();
  }

  public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
    ;
    System.out.println(note.stream().map(magazine::remove).anyMatch(aBoolean -> aBoolean.equals(false)) ? "No" : "Yes");

  }
}
// a b ab bb ba abb bba abba