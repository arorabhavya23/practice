package org.bhavya.practice;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class HourGlassArray {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<List<Integer>> arr = new ArrayList<>();

    IntStream.range(0, 6).forEach(i -> {
      try {
        arr.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int result = hourglassSum(arr);
    System.out.println(result);

//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();

    bufferedReader.close();
//    bufferedWriter.close();
  }

  public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
    // srart iteration from 1,1 till 4,4
    // pick the number pull out the hourglass from it create a function to extract all the values and give sum
    // store the sum in temp max variable
    // return the max sum
    int sum = Integer.MIN_VALUE;
    for (int i = 1; i < 5; i++) {
      for (int j = 1; j < 5; j++) {
        int tempSum = getHourGlassSum(arr, i, j);
        sum = Math.max(sum, tempSum);
      }
    }
    return sum;
  }

  private static int getHourGlassSum(List<List<Integer>> arr, int x, int y){
    int sum  = arr.get(x).get(y);
    sum += arr.get(x-1).get(y-1);
    sum += arr.get(x-1).get(y);
    sum += arr.get(x-1).get(y+1);
    sum += arr.get(x+1).get(y-1);
    sum += arr.get(x+1).get(y);
    sum += arr.get(x+1).get(y+1);
    return  sum;
  }

}
