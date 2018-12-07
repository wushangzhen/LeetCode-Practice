public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int sum = 0;
        int min = 0;
        int n = nums.size();
        int[] left = new int[n];
        int[] right = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            left[i] = max;
        }
        sum = 0;
        min = 0;
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            right[i] = max;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i + 1 < n; i++) {
            res = Math.max(res, left[i] + right[i + 1]);
        }
        return res;
    }
}
