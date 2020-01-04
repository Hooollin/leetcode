import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (47.97%)
 * Likes:    2740
 * Dislikes: 207
 * Total Accepted:    495.6K
 * Total Submissions: 961.5K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */

// @lc code=start

/* 数组里面查找第k大第k小的元素都可以通过快排来查找， 代码都大同小异，并且可以通过shuffle来避免最坏情况 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else
                break;
        }
        return nums[k];
    }

    public int partition(int[] nums, int lo, int hi) {
        int pivot = nums[0];
        while (lo < hi) {
            while (lo < hi && nums[hi] > pivot) {
                hi--;
            }
            int t = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = t;
            while (lo < hi && nums[lo] < pivot) {
                lo++;
            }
            t = nums[hi];
            nums[hi] = nums[lo];
            nums[lo] = t;
        }
        nums[lo] = pivot;
        return lo;
    }

}
// @lc code=end
