/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (41.29%)
 * Likes:    896
 * Dislikes: 1597
 * Total Accepted:    407.3K
 * Total Submissions: 984.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int currDigit = (carry + digits[i]) % 10;
            carry = (carry + digits[i]) / 10;
            digits[i] = currDigit;
        }
        if (carry != 0) {
            int[] rev = new int[digits.length + 1];
            rev[0] = carry;
            for (int i = 1; i < rev.length; i++) {
                rev[i] = digits[i - 1];
            }
            return rev;
        }
        return digits;
    }
}
