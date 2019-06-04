/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (32.03%)
 * Likes:    880
 * Dislikes: 1307
 * Total Accepted:    430.7K
 * Total Submissions: 1.3M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle == null) {
            return 0;
        }
        int[] prefix = buildPrefixTable(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (j == needle.length() - 1 && haystack.charAt(i) == needle.charAt(j))
                return i - j;
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = prefix[j];
                if (j == -1) {
                    j += 1;
                    i += 1;
                }
            }
        }
        return -1;
    }

    public int[] buildPrefixTable(String pattern) {
        int[] rev = new int[pattern.length()];
        int len = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                rev[i++] = ++len;
            } else {
                if (len == 0) {
                    rev[i++] = len;
                } else {
                    len = rev[len - 1];
                }
            }
        }
        for (int j = rev.length - 1; j > 0; j--) {
            rev[j] = rev[j - 1];
        }
        rev[0] = -1;
        return rev;
    }

}
