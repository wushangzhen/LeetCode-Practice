public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] leftMax = new int[n + 1];
        int[] rightMax = new int[n + 1];
        int[] leftMin = new int[n + 1];
        int[] rightMin = new int[n + 1];
        int sum = 0;
        int min = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            max = Math.max(sum - min, max);
            min = Math.min(min, sum);
            leftMax[i] = max;
            System.out.println(leftMax[i]);
        }
        sum = 0;
        min = 0;
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(sum - min, max);
            min = Math.min(min, sum);
            rightMax[i] = max;
        }
        sum = 0;
        min = Integer.MAX_VALUE;
        max = 0;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            min = Math.min(sum - max, min);
            max = Math.max(max, sum);
            leftMin[i] = min;
        }
        sum = 0;
        min = Integer.MAX_VALUE;
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            min = Math.min(sum - max, min);
            max = Math.max(max, sum);
            rightMin[i] = min;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.max(Math.abs(leftMin[i] - rightMax[i]), res);
            res = Math.max(Math.abs(leftMax[i] - rightMin[i]), res);
        }
        return res;
    }
}
