/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (38.44%)
 * Likes:    646
 * Dislikes: 34
 * Total Accepted:    48.5K
 * Total Submissions: 125.8K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's
 * permutations is the substring of the second string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * 
 * 
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1m = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1m[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2m = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2m[s2.charAt(j + i) - 'a']++;
            }
            if (matches(s1m, s2m)) {
                return true;
            }
        }
        return false;
    }

    public boolean matches(int[] s1m, int[] s2m) {
        for (int i = 0; i < 26; i++) {
            if (s1m[i] != s2m[i]) {
                return false;
            }
        }
        return true;
    }
}
