/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (43.73%)
 * Likes:    796
 * Dislikes: 80
 * Total Accepted:    85.8K
 * Total Submissions: 196.1K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * 
 * nums = [1, 2, 3]
 * target = 4
 * 
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 * 
 * 
 * 
 * 
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 * 
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test
 * cases.
 * 
 */
class Solution {
    // solution 1
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        return helper(nums, target, new HashMap<Integer, Integer>());
    }

    public int helper(int[] nums, int target, Map<Integer, Integer> m) {
        if (m.get(target) != null)
            return m.get(target);
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                res += helper(nums, target - nums[i], m);
        }
        m.put(target, res);
        return res;
    }

    // solution 2
    public int combinationSum4DP(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        // dp[i]代表target为i时的可能组合数
        int[] dp = new int[target + 1];
        // target == 0时组合为空集
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // 当target == i如果大于等于nums[j]，
                // 那么target == i的组合数则需要加上target == i - nums[j]的组合数
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
