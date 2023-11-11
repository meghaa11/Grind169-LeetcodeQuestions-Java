package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of integers nums, find all unique triplets in the array which gives the sum of zero (0).

Approach:

Brute Force Approach:
The simplest way to solve this problem is to use three loops, where each one keeps track of the elements in the triplet. 
For each triplet, we can find their sum and check whether it equals to zero or not.
This approach has a time complexity of O(n^3), hence we move on to the optimized approach.

Optimal Solution:
To find the triplets whose sum is zero, we can use the two-pointer technique along with sorting the array. The steps are as follows:
1. Sort the given array in ascending order.
2. Iterate over the array from left to right, considering each element as a potential candidate for the first
element of the triplet.
3. For each element, use two pointers, one starting from the next element (left pointer) and the other starting
from the last element (right pointer).
4. Calculate the sum of the current triplet (current element + left pointer + right pointer).
5. If the sum is less than zero, move the left pointer to the right to increase the sum.
6. If the sum is greater than zero, move the right pointer to the left to decrease the sum.
7. If the sum is zero, add the triplet to the result list and move both the left and right pointers towards the center to find other possible triplets.
8. Repeat steps 3-7 until the left pointer is less than the right pointer.
9. Skip duplicates: To avoid duplicate triplets, skip the elements with the same value as the previous element during iteration.
1. Return the list of unique triplets whose sum is zero.

Time Complexity: O(n^2), where n is the length of the input array.
The sorting step takes O(n log n) time, and the two-pointer traversal takes O(n^2) time in the worst case.

Space Complexity: O(1) (excluding the space required for the output list).
We are not using any additional data structures that grow with the input size.

Leetcode Link: https://leetcode.com/problems/3sum/

 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        // Sort the array in ascending order

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates for the first element

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num1 = nums[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                if (num1 + nums[left] + nums[right] == 0) {
                    // Found a triplet with sum zero
                    output.add(Arrays.asList(num1, nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (num1 + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return output;
    }
}
