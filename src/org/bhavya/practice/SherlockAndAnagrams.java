package org.bhavya.practice;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SherlockAndAnagrams {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String s = bufferedReader.readLine();

        int result = sherlockAndAnagrams(s);
        System.out.println(result);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }

  public static int sherlockAndAnagrams(String str) {
    // Write your code here
    List<String> subStrs = new ArrayList<>();
    int ans=0;
    for(int i=0;i<str.length();i++){
      for (int j = i+1; j <= str.length(); j++) {
        subStrs.add(str.substring(i, j));
      }
    }
    subStrs = (subStrs.stream().map(s -> {char[] vr = s.toCharArray(); Arrays.sort(vr); return new String(vr);}).sorted().collect(toList()));
    int n = 1;
    int i = 0;
    while(i < subStrs.size()-1){
      if(subStrs.get(i).equals(subStrs.get(++i))){
        n++;
      }
      else {
        ans += n * (n-1)/2;
        n = 1;
      }
    }
    ans += n * (n-1)/2;
    return (ans);
  }

}
