package org.bhavya.practice;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockValidString {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(
        new FileReader("src/org/bhavya/practice/shelockValidStringInput.txt"));

    String s = bufferedReader.readLine();

    String result = isValid("aabbc");
    System.out.println(result);

    bufferedReader.close();
  }

  public static String isValid(String s) {
    // Write your code here
    int[] arr = new int[26];
    for (int i = 0; i < s.length(); i++) {
      var pos = s.charAt(i) - 97;
      arr[pos]++;
    }
    int myVal = 0;
    int count = 0;
    int countCheck = 0;
    for (int i = 0; i < 26; i++) {
      if (arr[i] != 0) {
        if (myVal == 0) {
          myVal = arr[i];
        } else if (arr[i] - 1 == myVal || arr[i] == myVal - 1 || arr[i] - 1 == 0) {
          count++;
          myVal = countCheck >= 1 ? myVal : Math.min(myVal, arr[i]);
        } else if (arr[i] != myVal || count > 1) {

          return "NO";
        } else {
          countCheck++;
        }
      }
    }
    if (count > 1) {
      return "NO";
    }
    return "YES";

  }

}
