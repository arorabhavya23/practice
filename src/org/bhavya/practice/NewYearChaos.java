package org.bhavya.practice;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewYearChaos {

  static int[] temp = new int[100000];

  public static void minimumBribes(List<Integer> q) {
    // Write your code here
    boolean flag = false;
    var bribes = 0;
    var absDiff = 0;
    var smallArray = new ArrayList<Integer>();
    for (int i = 0; i < q.size(); i++) {
      int diff = q.get(i) - (i + 1);
      if (diff > 2) {
        flag = true;
        break;
      }
      absDiff += diff;
      if (diff != 0 || absDiff > 0) {
        smallArray.add(q.get(i));
      }
      if (absDiff == 0 && !smallArray.isEmpty()) {
        bribes += mergeInsertionSwap(smallArray.stream().mapToInt(value -> value).toArray(), 0,
            smallArray.size() - 1);
        smallArray.clear();
      }
    }
    System.out.println(flag ? "Too chaotic" : "" + bribes);

  }

  static int mergeInsertionSwap(int A[], int left, int right) {
    int swaps = 0;
    if (left < right) {
      int mid = left + (right - left) / 2;
      swaps += mergeInsertionSwap(A, left, mid);
      swaps += mergeInsertionSwap(A, mid + 1, right);
      swaps += merge(A, left, mid + 1, right);
    }
    return swaps;
  }

  static int merge(int A[], int left, int mid, int right) {

    int swaps = 0;
    int i = left, j = mid, k = left;
    while (i < mid && j <= right) {
      if (A[i] <= A[j]) {
        temp[k] = A[i];
        k++;
        i++;
      } else {
        temp[k] = A[j];
        k++;
        j++;
        swaps += mid - i;
      }
    }
    while (i < mid) {
      temp[k] = A[i];
      k++;
      i++;
    }

    while (j <= right) {
      temp[k] = A[j];
      k++;
      j++;
    }

    while (left <= right) {
      A[left] = temp[left];
      left++;
    }
    return swaps;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt).collect(toList());

        minimumBribes(q);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
