package org.bhavya.leetCode;
//https://leetcode.com/problems/median-of-two-sorted-arrays/

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the
 * two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array = [1,2,3] and median
 * is 2.
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array = [1,2,3,4] and
 * median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArrays {

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("please input sorted arr 1");
    var a1 = sc.nextLine().substring(1);
    System.out.println("please input sorted arr 2");
    var a2 = sc.nextLine().substring(1);
    var nums1 = Arrays.stream(a1.substring(0, a1.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
//    var nums2 = new int[0];
    var nums2 = Arrays.stream(a2.substring(0, a2.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
    MedianOfTwoSortedArrays mta = new MedianOfTwoSortedArrays();
    System.out.println(mta.findMedianSortedArrays(nums1, nums2));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length + nums2.length;
    var midPoint = len /2;
    var isEven = len%2 == 0;
    int i = 0, j = 0,k=0;
    var x = 1;
    var didI = new int[]{-1, -1}; //0 index - i, 1 - j
    while (i + j < len){
      if(i == nums1.length) {
        while (j < nums2.length) {
          j++;
          didI[1] = x;
          if (k == midPoint) {
            if (isEven) {
              if(nums1.length < 2){
                i = 1;
              }
              return  ((double) (nums2[j-1] +  (didI[0] == x-1 ? nums1[i-1] : nums2[j-2])) / 2);
            } else {
              return nums2[j-1];
            }
          }
          k++;
          x++;
        }
        break;
      }
      if(j == nums2.length){
        while(i < nums1.length) {
          i++;
          didI[0] = x;
          if(k == midPoint ){
            if(isEven){
              if(nums2.length < 2){
                j = 1;
              }
              return (double) (nums1[i-1] +  (didI[1] == x - 1 ? nums2[j-1] : nums1[i-2])) / 2;
            } else {
              return nums1[i-1];
            }
          }
          k++;
          x++;
        }
        break;
      }
      if(i < nums1.length  && j < nums2.length && nums1[i] < nums2[j]){
        i++;
        didI[0] = x;

      } else if(j < nums2.length) {
        j++;
        didI[1] = x;
      }
      if(k == midPoint){
        if(isEven){
          return  ((double) ((didI[0] == x ? nums1[i-1] : nums2[j-1]) +  (didI[1] == x-1 ? nums2[j-2] : nums1[i-2])) / 2);
//          return ((double) (Math.min(nums1[i-1], nums2[i-1]) + Math.max(nums1[i-2], nums2[j-2]))/2);
        } else {
          return didI[0] == x ? nums1[i-1] : nums2[j-1];
        }
      }
      k++;
      x++;
    }
//    return isEven ? ((double) (finalArr[midPoint] + finalArr[midPoint-1])) / 2 : finalArr[midPoint];
    return 0.0;
  }
//1 1 2 3 4

  //1 3 ->
  //2 4 ->

  // (0,0), (1,0) (1,1)
}
