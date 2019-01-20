class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (i != 0 && nums[i] > nums[i - 1]) {
                    swap(i, nums);
                }
            } else {
                if (i != 0 && nums[i] < nums[i - 1]) {
                    swap(i, nums);
                }
            }
        }
        return;
    }
    void swap(int index, int[] nums) {
        int temp = nums[index];
        nums[index] = nums[index - 1];
        nums[index - 1] = temp;
    }
}
