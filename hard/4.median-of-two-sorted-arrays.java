/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (26.37%)
 * Likes:    4318
 * Dislikes: 574
 * Total Accepted:    437.1K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {

    // time complexity isn't log(m + n)...
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middleIdx = (nums1.length + nums2.length) >> 1;
        int[] combinedArray = new int[nums1.length + nums2.length];
        int p1 = 0, p2 = 0;
        int idx = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                combinedArray[idx++] = nums1[p1++];
            } else {
                combinedArray[idx++] = nums2[p2++];
            }
        }
        while (p1 < nums1.length) {
            combinedArray[idx++] = nums1[p1++];
        }
        while (p2 < nums2.length) {
            combinedArray[idx++] = nums2[p2++];
        }

        if (combinedArray.length % 2 == 0) {
            return (combinedArray[middleIdx] + combinedArray[middleIdx - 1]) / 2.0;
        } else {
            return combinedArray[middleIdx];
        }
    }
}
