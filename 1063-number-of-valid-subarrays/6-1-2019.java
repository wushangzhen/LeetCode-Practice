class Solution {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j] >= nums[i]) {
                j++;
            }
            sum += j - i;
        }
        return sum;
    }
}
