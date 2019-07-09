/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (33.62%)
 * Likes:    1697
 * Dislikes: 90
 * Total Accepted:    316.4K
 * Total Submissions: 936.5K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                lo = mid;
                hi = mid;
                break;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo > hi) {
            return new int[] { -1, -1 };
        }

        while (lo > 0 && nums[lo - 1] == target) {
            lo -= 1;
        }
        while (hi < nums.length - 1 && nums[hi + 1] == target) {
            hi += 1;
        }

        return new int[] { lo, hi };
    }
}
