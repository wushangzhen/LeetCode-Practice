class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] >= temp) {
                    right--;
                } else {
                    count += right - left;
                    left++;
                }
            }
        }
        return count;
    }
}
