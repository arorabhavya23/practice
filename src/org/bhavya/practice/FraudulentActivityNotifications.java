package org.bhavya.practice;

//https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting

import static java.util.Collections.binarySearch;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FraudulentActivityNotifications {

  private static int count = 0;

  static FileWriter writer;

  static {
    try {
      writer = new FileWriter(
          "C:\\Users\\arora\\projects\\practice\\src\\org\\bhavya\\practice\\testout.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static BufferedWriter buffer = new BufferedWriter(writer);


  public static int activityNotifications(List<Integer> expenditure, int d) throws IOException {

    // Write your code here
    List<Integer> checkExpenditure = new ArrayList<>();
    int notificationCount = 0;
    if (d >= expenditure.size()) {
      return 0;
    }
    var j = 0;
    while (j < d) {
      int index = getIndexNew(checkExpenditure, expenditure.get(j));
      checkExpenditure.add(index, expenditure.get(j));
      j++;
    }

    for (int i = d; i < expenditure.size(); i++) {
      var mid =d / 2;
      Double median =
          d % 2 == 0 ?
              (checkExpenditure.get(mid) + checkExpenditure.get(mid - 1))
              : (checkExpenditure.get(mid) * 2.0);
      if (expenditure.get(i) >= median) {
        notificationCount++;
      }
      ;
      checkExpenditure.remove(binarySearch(checkExpenditure, expenditure.get(i-d)));
      int index = getIndexNew(checkExpenditure, expenditure.get(i));
      checkExpenditure.add(index, expenditure.get(i));
    }
    return notificationCount;

  }

  static Integer getIndexNew(List<Integer> list, Integer element) {
    /**
     *  check for middle element
     *  check for element below middle
     *      if there change size to middle
     *          make mid to mid of first half
     *          redo all the checks
     *  check for element above middle
     *      if there change size to middle
     *        *          make mid to mid of second half
     *        *          redo all the checks
     */
    var start = 0;
    var end = list.size();
    var mid = (start + end) / 2;
    while (start <= mid && end > mid) {
      if (list.get(start) > element) {
        return start;
      }
      if (list.get(end - 1) < element) {
        return end;
      }
      var midElement = list.get(mid);
      if (element >= list.get(mid - 1) && element <= midElement) {
        return mid;
      }
      if (element <= list.get(mid + 1) && element >= midElement) {
        return mid + 1;
      }
      if (element < midElement) {
        end = mid;
      } else {
        start = mid + 1;
      }
      mid = (start + end) / 2;
    }
    return mid;
  }

  public static void main(String[] args) throws IOException {
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    long startTime = System.nanoTime();
    System.out.println(startTime);

    BufferedReader bufferedReader = new BufferedReader(new FileReader(
        "C:\\Users\\arora\\projects\\practice\\src\\org\\bhavya\\practice\\inputActivity.txt"));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int d = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> expenditure = Stream.of(
            bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = activityNotifications(expenditure, d);
    System.out.print("result is " + result + " \ntime taken is ");

    bufferedReader.close();
    long endTime = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println(totalTime / 1_000_000);
    buffer.close();
  }

}

/*
10 4
2  3  4  2  3  7  8  4 6 5
2, 2, 3, 4
2, 3, 3, 4
3, 3, 4, 7
3, 4, 7, 8
4, 4, 7, 8
4, 6, 7, 8
5, 6, 7, 8

 */
