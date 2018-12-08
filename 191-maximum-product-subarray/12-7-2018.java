class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] max = new int[n + 1];
        int[] min = new int[n + 1];
        max[0] = 1;
        min[0] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= 0) {
                max[i] = Math.max(max[i - 1] * nums[i - 1], nums[i - 1]);
                min[i] = Math.min(min[i - 1] * nums[i - 1], nums[i - 1]);
            } else {
                max[i] = Math.max(min[i - 1] * nums[i - 1], nums[i - 1]);
                min[i] = Math.min(max[i - 1] * nums[i - 1], nums[i - 1]);
            }
            res = Math.max(max[i], res);
        }
        return res;
    }
}
