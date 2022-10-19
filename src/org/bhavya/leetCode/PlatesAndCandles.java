package org.bhavya.leetCode;

//https://leetcode.com/problems/plates-between-candles/

/**
 * There is a long table with a line of plates and candles arranged on top of it. You are given a
 * 0-indexed string s consisting of characters '*' and '|' only, where a '*' represents a plate and
 * a '|' represents a candle.
 * <p>
 * You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti]
 * denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the number
 * of plates between candles that are in the substring. A plate is considered between candles if
 * there is at least one candle to its left and at least one candle to its right in the substring.
 * <p>
 * For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". The number of
 * plates between candles in this substring is 2, as each of the two plates has at least one candle
 * in the substring to its left and right. Return an integer array answer where answer[i] is the
 * answer to the ith query.
 * <p>
 * Solution Create Array for plate list having index of all candle for every query check if the
 * diffrence if right and left is less than equal to 1 so return 0 for else do a binary search for
 * nearest possible plate calculate difference between left and right plate and their index to
 * counter or any plate that is in between
 * <p>
 * Solution Create Array for plate list having index of all candle for every query check if the
 * diffrence if right and left is less than equal to 1 so return 0 for else do a binary search for
 * nearest possible plate calculate difference between left and right plate and their index to
 * counter or any plate that is in between
 */

/**
 * Solution
 * Create Array for plate list having index of all candle
 * for every query check if the diffrence if right and left is less than equal to 1 so return 0
 * for else do a binary search for nearest possible plate
 * calculate difference between left and right plate and their index to counter or any plate that is in between
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class PlatesAndCandles {

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println(
        "please input String input for plates and candles in form of * and | where * is a plate and | is a candle");
    var s = sc.nextLine();
    System.out.println("please provide queries in form of 2D array");
    var query = sc.nextLine().substring(2);
    var queryList = query.substring(0, query.length() - 2).split("],\\[");
    var queries = new int[queryList.length][];
    var r = 0;
    for (String row : queryList) {
      queries[r++] = Arrays.stream(row.split(",")).mapToInt(Integer::parseInt).toArray();
    }
    PlatesAndCandles pnC = new PlatesAndCandles();
//    System.out.println(Arrays.toString(pnC.platesBetweenCandles(s, queries)));
    System.out.println(Arrays.toString(pnC.platesBetweenCandlesFast(s, queries)));

  }

  public int[] platesBetweenCandles(String s, int[][] queries) {
    var res = new int[queries.length];
    var plates = new ArrayList<Integer>(); //treeSet
//    var plates = new TreeSet<Integer>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '|') {
        plates.add(i);
      }
    }
    for (int i = 0; i < queries.length; i++) {
      var l = queries[i][0];
      var r = queries[i][1];
      /*var search = searchLinear(plates, l, r);
      if (search[0] == search[1]) {
        res[i] = 0;
      } else {*/
      if (r - l <= 1) {
        res[i] = 0;
      } else {
        var a = searchBinaryLeft(plates, l);
        var b = searchBinaryRight(plates, r);
        res[i] = Math.max((b[0] - a[0] - (b[1] - a[1])), 0);
      }
    }
    return res;
  }

  private int[] searchLeftPlate(List<Integer> plates, Integer l) { // would return ->  value , index
    var e = plates.size();
    var s = 0;
    var res = new int[2];
    while (s < e) {
      if (l <= plates.get(s)) {
        res = new int[]{plates.get(s), s};
        e = -1;
      } else if (l.equals(plates.get(e - 1))) {
        res = new int[]{plates.get(e - 1), e - 1};
        e = -1;
      } else if (l < plates.get((s + e) / 2)) {
        e = (s + e) / 2;
      } else {
        s = ((s + e) / 2);
      }
    }
    return res;
  }

  private int[] searchRightPlate(List<Integer> plates,
      Integer r) { // would return ->  value , index
    var e = plates.size();
    var s = 0;
    var res = new int[2];
    while (s < e) {
      if (r >= plates.get(e - 1)) {
        res = new int[]{plates.get(e - 1), e - 1};
        e = -1;
      } else if (r.equals(plates.get(s))) {
        res = new int[]{plates.get(s), s};
        e = -1;
      } else if (r < plates.get((s + e) / 2)) {
        e = (s + e) / 2;
      } else {
        s = ((s + e) / 2);
      }
    }
    return res;
  }

  private int[][] searchLinear(List<Integer> plates, Integer l, Integer r) {
    var s = plates.size() - 1;
    var res = new int[2][2];
    boolean lF = false, rF = false;
    for (int i = 0; i <= s; i++) {
      if (l <= plates.get(i) && !lF) {
        res[0] = new int[]{plates.get(i), i};
        lF = true;
      }
      if (r >= plates.get(s - i) && !rF) {
        res[1] = new int[]{plates.get(s - i), s - i};
        rF = true;
      }
      if (rF && lF) {
        break;
      }
    }
    return res;
  }

  private int[] searchBinaryLeft(List<Integer> plates,
      Integer l) { // would return ->  value , index
    var e = plates.size();
    var s = 0;
    var res = new int[2];
    plates.contains(9);
    if (l <= plates.get(s)) {
      return new int[]{plates.get(s), 0};
    }
    while (s < e) {
      var mid = (s + e) / 2;
      mid = mid == plates.size() - 1 ? mid - 1 : mid;
      mid = mid == 0 ? mid + 1 : mid;
      if (isInBetween(plates.get(mid - 1), plates.get(mid + 1),
          l)) {  // 3  6  12  15  16  19 --> [15, 17]
        if (l > plates.get(mid)) {
          res = new int[]{plates.get(mid + 1), mid + 1};
        } else if (l > plates.get(mid - 1)) {
          res = new int[]{plates.get(mid), mid};
        } else {
          res = new int[]{plates.get(mid - 1), mid - 1};
        }
        e = -1;
      } else if (l > plates.get(mid + 1)) {
        s = mid + 2;
      } else {
        e = mid - 1;
      }
    }
    return res;
  }

  private int[] searchBinaryRight(List<Integer> plates,
      Integer r) { // would return ->  value , index
    var e = plates.size();
    var s = 0;
    var res = new int[2];
    if (r >= plates.get(e - 1)) {
      return new int[]{plates.get(e - 1), e - 1};
    }
    while (s < e) {
      var mid = (s + e) / 2;
      mid = mid == plates.size() - 1 ? mid - 1 : mid;
      mid = mid == 0 ? mid + 1 : mid;
      if (isInBetween(plates.get(mid - 1), plates.get(mid + 1),
          r)) {     // 3  6  12  15  16  19 --> [2,8]   // 2  5  9   --> 9 /// r >= mid & r <= mid + 1
        if (r < plates.get(mid)) {
          res = new int[]{plates.get(mid - 1), mid - 1};
        } else if (r < plates.get(mid + 1)) {
          res = new int[]{plates.get(mid), mid};
        } else {
          res = new int[]{plates.get(mid + 1), mid + 1};
        }
        e = -1;
      } else if (r > plates.get(mid + 1)) {
        s = mid + 1;
      } else {
        e = mid - 1;
      }
    }
    return res;
  }

  private boolean isInBetween(int a, int b, int find) {
    return find >= a && find <= b;
  }


  /**
   *
   * create 2 array one each for left and right
   * in array for left store the position of next array ie traves PnC from end and then store
   * in array for right store the position of previous candle for each plate ie traverse from start
   */
  public int[] platesBetweenCandlesFast(String s, int[][] queries) {
    var res = new int[queries.length];
    var candles = new HashMap<Integer, Integer>(); // map of candle and positionn
    var leftCandles = new int[s.length()];
    var rightCandles = new ArrayList<Integer>(s.length());
    var right = 0;
    var left = s.length();
    var pos = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '|') {
        candles.put(i, pos++);
        right = i;
      }
      rightCandles.add(right);
      if (s.charAt(s.length() - i - 1) == '|') {
        left = s.length() - i - 1;
      }
      leftCandles[s.length() - i - 1] = left;
    }
    for (int i = 0; i < queries.length; i++) {
      var l = queries[i][0];
      var r = queries[i][1];
      if (r - l <= 1) {
        res[i] = 0;
      } else {
        var a = leftCandles[l];
        var b = rightCandles.get(r);
        res[i] = Math.max((b - a - (candles.get(b) - candles.get(a))), 0);
      }
    }
    return res;
  }
}
// 3  6  12  15  16  19
