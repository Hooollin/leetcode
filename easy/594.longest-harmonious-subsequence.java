/*
 * @lc app=leetcode id=594 lang=java
 *
 * [594] Longest Harmonious Subsequence
 *
 * https://leetcode.com/problems/longest-harmonious-subsequence/description/
 *
 * algorithms
 * Easy (43.83%)
 * Likes:    418
 * Dislikes: 56
 * Total Accepted:    36.9K
 * Total Submissions: 84.2K
 * Testcase Example:  '[1,3,2,2,5,2,3,7]'
 *
 * We define a harmounious array as an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 * 
 * Now, given an integer array, you need to find the length of its longest
 * harmonious subsequence among all its possible subsequences.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * 
 * 
 * 
 * Note: The length of the input array will not exceed 20,000.
 * 
 */
class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int maxLength = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int val = nums[i];
            int curLength = 0;
            boolean hasNext = false;
            for (int k = i; k < nums.length; k++) {
                if (val == nums[k]) {
                    i = k;
                    curLength += 1;
                    continue;
                }
                if (val + 1 == nums[k]) {
                    hasNext = true;
                    curLength += 1;
                    continue;
                }
                break;
            }
            if (hasNext)
                maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }
}
