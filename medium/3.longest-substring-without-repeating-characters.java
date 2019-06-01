/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.38%)
 * Likes:    5557
 * Dislikes: 310
 * Total Accepted:    933.8K
 * Total Submissions: 3.3M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {

    // sliding window
    public int lengthOfLongestSubstring(String s) {
        int[] m = new int[256];
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            m[s.charAt(end)] += 1;
            while (start < end && m[s.charAt(end)] > 1) {
                m[s.charAt(start)] -= 1;
                start += 1;
            }
            res = Math.max(end - start + 1, res);
        }
        return res;
    }
}
