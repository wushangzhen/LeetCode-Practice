class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        int n = nums.length;
        int count = 0;
        while (right < n) {
            if (nums[right] == 1) {
                right++;
                continue;
            } else if (count == 0) {
                count++;
                right++;
                continue;
            } else {
                max = Math.max(right - left, max);
                while (count != 0) {
                    if (nums[left] == 0) {
                        count--;
                    }
                    left++;
                }
            } 
        }
        max = Math.max(right - left, max);
        return max;
    }
}
