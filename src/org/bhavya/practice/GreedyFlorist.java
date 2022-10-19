package org.bhavya.practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/greedy-florist/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms


public class GreedyFlorist {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0]);

    int k = Integer.parseInt(nk[1]);

    int[] c = new int[n];

    String[] cItems = scanner.nextLine().split(" ");

    for (int i = 0; i < n; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

    int minimumCost = getMinimumCost(k, c);
    System.out.println(minimumCost);

    scanner.close();
  }

  static int getMinimumCost(int k, int[] c) {
    int minCost = 0;
    Arrays.sort(c);
    System.out.println(Arrays.toString(c));
    int n = c.length;
    int friends = k;
    int steps = 0;
    while(k > 0){
      int count = 0;
      for(int i = n-k; i >= 0; i-=friends){
        minCost += (1+count) * c[i];
        count++;
        steps++;
      }
      System.out.println(steps);
      System.out.println(minCost);
      k--;
    }
    System.out.println(steps);
    return minCost;

  }
}

//190125160
//163578911

  // Complete the getMinimumCost function below.
