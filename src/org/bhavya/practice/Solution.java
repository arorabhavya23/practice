package org.bhavya.practice;

import java.util.HashMap;

public class Solution {
  public static int findMinFountains(int arr[], int n) {
    // Write your code here.
    // 2D vector to store the range for every fountain.
    int range[][] = new int[n + 1][2];
    for (int i = 0; i <= n; i++) {
      int idxLeft = Math.max(i - arr[i], 0);
      int idxRight = Math.min(i + (arr[i]), n);
      range[i][0] = idxLeft;
      range[i][1] = idxRight;
    }
    // Creating a hashmap to store the maximum endings.
    HashMap<Integer, Integer> max_ends = new HashMap<>();
    for (int clip[] : range) {
      // Getting the max end for each starting point.
      if (!max_ends.containsKey(clip[0])) {
        max_ends.put(clip[0], clip[1]);
      } else {
        max_ends.put(clip[0], Math.max(max_ends.get(clip[0]), clip[1]));
      }
    }
    int currEnd = -1;
    int isReachable = 0;
    int ans = 0;
    for (int i = 0; i <= n; i++) {
      // If there is a break between arr or we already reached the end, return.
      if (isReachable >= n || i > isReachable) {
        break;
      }
      // If clip with i as starting point exists.
      if (max_ends.containsKey(i)) {
 /*
Increase the ans if starting point
is greater than previously selected clip.
*/
        if (i > currEnd) {
          ans++;
          // New selected fountain ends at max end.
          currEnd = isReachable;
        }

/*
Maximize reachable end till starting point
is less than or equal topreviously selected fountain.
*/
        isReachable = Math.max(isReachable, max_ends.get(i));
      }
    }
    if (isReachable >= n) {
      return ans;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println(findMinFountains(new int[]{2, 0, 0, 0}, 3));
  }
}
