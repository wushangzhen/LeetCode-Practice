class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i]) {
                i++;
            } else {
                swap(i, nums[i] - 1, nums);
            }
        }
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return i + 1;
    } 
    void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
