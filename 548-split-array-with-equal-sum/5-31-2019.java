class Solution {
    public boolean splitArray(int[] nums) {
        int j = 0;
        int n = nums.length;
        if (n < 6) {
            return false;
        }
        int[] preSum = new int[n + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (; j + 1 < nums.length - 1; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i + 1 < j; i++) {
                if (preSum[i] == preSum[j] - preSum[i + 1]) {
                    set.add(preSum[i]);
                }
            }
            for (int k = j + 2; k < n - 1; k++) {
                if (preSum[k] - preSum[j + 1] == preSum[n] - preSum[k + 1] && set.contains(preSum[k] - preSum[j + 1])) {
                    return true;
                }
            }
        }
        return false;
    }
}
