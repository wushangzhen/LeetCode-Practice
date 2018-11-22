class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                preSum[i] = sum;
                continue;
            }
            sum += nums[i - 1];
            preSum[i] = sum;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = findLeft(i + 1, preSum, s);
            if (left != -1) {
                min = Math.min(i - left + 1, min);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    int findLeft(int right, int[] preSum, int s) {
        int temp = right;
        int left = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (preSum[temp] - preSum[mid] >= s) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (left == 0 && preSum[temp] - preSum[left] < s) {
            return -1;
        }
        if (preSum[temp] - preSum[right] >= s) {
            return right;
        } 
        return left;
    }
}
