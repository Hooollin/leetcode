/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (45.28%)
 * Likes:    1395
 * Dislikes: 66
 * Total Accepted:    97K
 * Total Submissions: 214.2K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a
 * target, S. Now you have 2 symbols + and -. For each integer, you should
 * choose one from + and - as its new symbol.
 * ⁠
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.  
 * 
 * 
 * Example 1:
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 * 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array is positive and will not exceed 20. 
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 * 
 * 
 */
class Solution {

    // DFS.. need to figure out dp method
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0)
            return 0;
        return f(nums, S, 0);
    }

    public int f(int[] nums, int S, int innerStart) {
        if (innerStart == nums.length) {
            if (S == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int res = 0;
        res += f(nums, S + nums[innerStart], innerStart + 1);
        res += f(nums, S - nums[innerStart], innerStart + 1);
        return res;
    }
}
