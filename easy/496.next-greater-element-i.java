/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */
class Solution {

    // 用stack来存所有还没有找到nextGreaterElement的item,此时栈顶一定是最小的element,
    // 碰到栈顶大的item就pop并记录，直到没有比这个item更大的为止，最后将item入栈。
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 0 || nums1.length == 0) {
            return new int[0];
        }
        int[] nextGreaterIdxs = new int[nums2.length];
        int[] res = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            while (!s.isEmpty() && nums2[s.peek()] < nums2[i]) {
                nextGreaterIdxs[s.pop()] = nums2[i];
            }
            s.push(i);
        }
        // 栈不空时要将还在栈内的元素的nextGreaterElementIdx置为-1
        while (!s.isEmpty()) {
            nextGreaterIdxs[s.pop()] = -1;
        }
        int idx = 0;

        for (int num : nums1) {
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] == num) {
                    res[idx] = nextGreaterIdxs[i];
                    break;
                }
            }
            idx += 1;
        }
        return res;
    }
}
