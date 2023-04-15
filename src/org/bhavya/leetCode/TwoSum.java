package org.bhavya.leetCode;
//https://leetcode.com/problems/two-sum/

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] + nums[1] == 9,
 * we return [0, 1]. Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
 * <p>
 * Input: nums = [3,3], target = 6 Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 104 -109 <= nums[i] <= 109 -109 <= target <= 109 Only one valid answer
 * exists.
 * <p>
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] r = twoSum(new int[]{2,7,11,15}, 9);
    System.out.println(r[0] + ", " + r[1]);
  }

  public static int[] twoSum(int[] num, int target) {

    int[] result = new int[2];
    var nums = Arrays.stream(num).sorted().toArray();

    var i = 0;
    var s = 0;
    var j = nums.length;
    while (i < j && s < nums.length) {
      var mid = (i + j) / 2;
      if (nums[s] + nums[mid] == target) {
        return new int[]{findIndex(num, nums[s]), findIndex(num, nums[mid])};
      } what
      s++;
    }
    return result;
  }

  public static int findIndex(int arr[], int t) {
    int len = arr.length;
    int i = 0;
    while (i < len) {

      if (arr[i] == t) {
        return i;
      } else {
        i = i + 1;
      }
    }
    return -1;
  }
}
