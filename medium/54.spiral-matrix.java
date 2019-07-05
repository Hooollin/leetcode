/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (30.54%)
 * Likes:    1155
 * Dislikes: 421
 * Total Accepted:    242.8K
 * Total Submissions: 790.1K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int x = 0, y = 0;
        int curDir = 0;
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < R * C; i++) {
            res.add(matrix[x][y]);
            seen[x][y] = true;
            int tempX = x + directions[curDir][0];
            int tempY = y + directions[curDir][1];
            if (tempX >= 0 && tempX < R && tempY >= 0 && tempY < C && !seen[tempX][tempY]) {
                x = tempX;
                y = tempY;
            } else {
                curDir = (1 + curDir) % directions.length;
                x += directions[curDir][0];
                y += directions[curDir][1];
            }
        }
        return res;
    }
}
