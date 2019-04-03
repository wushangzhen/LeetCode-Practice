class Solution {
    public int candy(int[] ratings) {
        int res = 0, n = ratings.length;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        for (int i = 0; i < n - 1; ++i) {
            if (ratings[i + 1] > ratings[i]) {
                nums[i + 1] = nums[i] + 1;
            }
        }
        for (int i = n - 1; i > 0; --i) {
            if (ratings[i - 1] > ratings[i]) {
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
            }
        }
        for (int i : nums) {
            res += i;
        }
        return res;
    }
}
