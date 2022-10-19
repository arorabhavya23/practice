package org.bhavya;

/**
 * [8:44 PM] Vegesna, Rohith Varma (Guest) Given an integer array nums of length n and an integer
 * target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers. You may assume that each input would have exactly one
 * solution.
 * <p>
 * Example 1: Input: nums = [-1,2,1,-4], target = 1 Output: 2 Explanation: The sum that is closest
 * to the target is 2. (-1 + 2 + 1 = 2). Example 2: Input: nums = [0,0,0], target = 1 Output: 0
 */
public class SolutionOne {

  public static void main(String[] arg){
    System.out.println(closestSum(new Integer[]{-1, 2, 1, -4}, 1));
    System.out.println(closestSum(new Integer[]{0, 0,0}, 1));
    System.out.println(closestSum(new Integer[]{-1, -4, 1, 9, -5, 2}, 1));
  }

  //Input: nums = [-1, -4, 1, 9, 7, 2], target = 1
  public static Integer closestSum(Integer[] nums, Integer target) {
    //check if the sum is never 0
    var sum = 0;
    if (nums.length >= 3) {
      sum = nums[0] + nums[1] + nums[2];
    } else {
      return null;
    }
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          var tempSum = nums[i] + nums[j] + nums[k];        //-1 + -4 + 1 = -4  // -1-4 9 = 4 //1 -4 -5 = -8 // -1 -4 2 = 3 // -1 1 9 = 10 // -1 1 -5 = -5 // -1 1 2 = 2 // -1 9 -5 =
          if (Math.abs(target - tempSum) <= Math.abs(target - sum)) { // true // true // false // true //false //false //true
            sum = tempSum;        // 2
            if (sum == target) {
              return sum;
            }
          }
        }
      }

    }

    return sum;
  }

}
