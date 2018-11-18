class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] prev = new int[n];
        int[] post = new int[n];
        prev[0] = 1;
        post[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prev[i] = nums[i - 1] * prev[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            post[i] = nums[i + 1] * post[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prev[i] * post[i];
        }
        return res;
    }
}
