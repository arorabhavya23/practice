package org.bhavya.practice;

//https://www.hackerrank.com/challenges/special-palindrome-again/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SpecialString {

  static int opr = 0;
  /**
   * inside out approach
   * check the whole String first
   * check the  first half and second half
   * then keep on diving and checking till you find the result
   * where ever found call the subString count function and add the rest of values
   *
   * funct -> get the subString Count(subString){
   *   if middle char then return n = size/2 -> 2 * ((n^2 + n) / 2) + 1
   *    *    else just return (n^2 + n) / 2
   * }
   */

  static long substrCount(int n, String s) {
    long count = 0;
    opr++;
    if(isSpecial(s)){
      opr++;
      System.out.println("susbstring is " + s);
      if(n%2 == 0 && s.charAt(n/2) != s.charAt((n/2)-1)){
        opr++;
        return 2 * ((long) (Math.pow(n/2, 2) + n/2) / 2) + 1;
      } else {
        opr++;
        return ((long) Math.pow(n, 2) + n)/2;
      }
    } else {
      opr++;
      count += substrCount(n/2,  s.substring(0, n/2));
      opr++;
      count += substrCount(n/2,  s.substring(n/2+1, n));
    }
    opr++;
    return count;
  }

  static boolean isSpecial(String s){
    //aa
    opr++;
    int size = s.length();
    opr++;
    if(size == 2){
      opr++;
      return s.charAt(0) == s.charAt(1);
    }
    opr++;
    for (int i = 0; i < size/2; i++) {
      opr++;
      if(s.charAt(i) != s.charAt(size-i-1) || s.charAt(0) != s.charAt(i)){    //a,a //b,b
        opr++;
        return false;
      }
    }
    opr++;
    return true;
  }

  /**
   * longest common substring kind approach
   *
   * take every element of string and where it matches mark as 1
   * for next element ie in continuation make it  +1
   * if encountered mismatch make it 0 and then start again with a 1
   * keep the index of every 1 and change it to the highest count in that sub-series
   * once we have max number(the highest count in that series > 1) we can calculate number of substrings using formula n(n-1)/2
   * check for the index and if the element 2 place behind is non zero then it is also a substring
   * * the sum for that would be
   * * minimum of the number around 0 eg. 3 0 5 then substrings would be 3,
   * * as we have already calculated for 3 and 5 separately it only involves for the substrings which have mid-element as different.
   * eg. for NNONNOOONOOONO
   * arr for N would be -> 11011000100010 -> 22022000100010
   * for O would be 00100111011101 -> 00100323032301
   * when the next N comes ignore as it is already calculated same for next repeating elements
   *
   * Algo
   *
   * finalCount = strLen
   * for i (0 -> str len)
   *  new arr[str len] = 0
   *  if str[i] not checked before (check by adding in set)
   *    count = 0;
   *    index = 0;
   *    for j (i -> str len)
   *      if(str[i] = str[j]) then
   *        count++
   *        arr[j] = count
   *        if index == 0 then index = j
   *      else
   *        finalCount = finalCount + count(count-1)/2
   *        arr[index] = count
   *        if(index >= 2 and arr[index-2] > 0)
   *          finalCount = finalCount + minOf(arr[index], arr[index-2]
   *        count = 0;
   *        index = -1;
   *    if(arr[strlen] > 0)
   *      finalCount = finalCount + count(count-1)/2
   *
   * return finalCount
   *
   */

//  private static final Scanner scanner = new Scanner(System.in);

  private static long countSubstrings(int n, String s) {
    long finalCount = n;
    int totalMatches = 0;
    Set<Character> check = new HashSet<>();
    for (int i = 0; i < n && totalMatches < n; i++) {
      var arr = new int[n];
      var ch = s.charAt(i);
      if (check.add(ch)) {
        var count = 0;
        var index = 0;
        for (int j = i; j < n; j++) {
          if (s.charAt(i) == s.charAt(j)) {
            count++;
            arr[j] = count;
            index = index == 0 ? j : index;
          } else {
            finalCount += ((long) count * (count - 1) / 2);
            arr[index] = count;
            totalMatches += count;
            if (index >= 2 && arr[index - 2] > 0) {
              finalCount += min(arr[index], arr[index - 2]);
            }
            index = 0;
            count = 0;
          }
        }
        if(count > 0){
          totalMatches += count;
          finalCount += ((long) count * (count - 1) / 2);
          if (index >= 2 && arr[index - 2] > 0) {
            finalCount += min(arr[index], arr[index - 2]);
          }
        }
      }
    }

    return finalCount;
  }

  public static void main(String[] args) throws IOException {

//    int n = scanner.nextInt();
//    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//    String s = scanner.nextLine();
    var start = System.currentTimeMillis()/100;
    System.out.println("start at " + (start));
    BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\arora\\projects\\practice\\src\\org\\bhavya\\practice\\SpecialString.txt"));
   int n = Integer.parseInt(bufferedReader.readLine().trim());
   String s = bufferedReader.readLine().replaceAll("\\s+$", "");
    System.out.println("input complete for " + n + " chars");

//    long result = substrCount(n, s);
    long result = countSubstrings(n, s);
    System.out.println(result);
//    System.out.println("operations are " + opr);

//    scanner.close();
    bufferedReader.close();
    var end = System.currentTimeMillis()/100;
    System.out.println("end at " + (end));
    var timeTaken = end - start;
    System.out.println(timeTaken);
  }
}
