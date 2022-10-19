package org.bhavya.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeSortCountingInversions {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        long result = countInversions(arr);
        System.out.println("\n" + result);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }

  public static long countInversions(List<Integer> arr) {
    // Write your code here
    return mergeSortCount(arr.toArray(new Integer[0]), new Integer[arr.size()], 0, arr.size()-1);
  }

  private static long mergeSortCount(Integer[] a, Integer[] aux, int from, int to) {
    if (from >= to) { return 0; }
    int mid = (from + to) >>> 1;
    long count = 0L;
    count += mergeSortCount(a, aux, from, mid);
    count += mergeSortCount(a, aux, mid + 1, to);
    count += merge(a, aux, from, mid, to);
    return count;
  }

  private static long merge(Integer[] a, Integer[] aux, int from, int mid, int to) {
    System.arraycopy(a, from, aux, from, to - from + 1);
    long count = 0L;
    int i = from, j = mid + 1;
    for (int k = from; k <= to; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > to) {
        a[k] = aux[i++];
      } else if (aux[j] < aux[i]) {
        a[k] = aux[j++];
        count += mid - i + 1;
      } else {
        a[k] = aux[i++];
      }
    }
    return count;
  }

}

/*
2
5
1 1 1 2 2
5
02 01 03 01 02
01 01 02 02 03

01 00 01 -1 -1



 */
