class Solution {
    void swapItem(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    void swapList(int start, int end, int[] nums) {
        while (start < end) {
            swapItem(start, end, nums);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 && nums.length == 1) {
            return;
        }
        int n = nums.length;
        int i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        int j = n - 1;
        if (i == 0) {
            swapList(i, n - 1, nums);
            return;
        } else {
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swapItem(i - 1, j, nums);
            swapList(i, n - 1, nums);
        }
    }
}
