class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (left < nums.length) {
            while (right < nums.length && sum < s) {
                sum += nums[right];
                right++;
            }
            if (left < nums.length && sum >= s) {
                min = Math.min(right - left, min); 
            }
            sum -= nums[left];
            left++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
