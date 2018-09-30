public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
            
        int n = nums.length;
        int[][] f = new int[n + 1][2];
        f[0][0] = 0;
        f[0][1] = 0;
        int i, j, k, t;
        for (i = 1; i <= n; i++) {
            for (j = 0; j < 2; j++) {
                f[i][j] = Integer.MAX_VALUE;
                t = 0;
                if (j != nums[i - 1]) {
                    t++;
                }
                for (k = 0; k < 2; ++k) { // represent last number's two states
                    if (k == 0 && j == 1) {
                        continue;
                    }
                    f[i][j] = Math.min(f[i - 1][k] + t, f[i][j]);
                }
            }
        }
        return Math.min(f[n][0], f[n][1]);
    }
}
