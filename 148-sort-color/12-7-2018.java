class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] < 1) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
            if (nums[i] > 1) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
                i--;
            }
            i++;
        }
    }
}
