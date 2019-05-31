class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0; size++) {
                int temp = nums[k];
                nums[k] = -1;
                k = temp;
            }
            max = Math.max(size, max);
        }
        return max;
    }
}
