class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max[i] = nums[i];
            min[i] = nums[i];
            if (i > 0 && nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            }
            if (i > 0 && nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            res = Math.max(max[i], res);
        }
        return res;
    }
}
