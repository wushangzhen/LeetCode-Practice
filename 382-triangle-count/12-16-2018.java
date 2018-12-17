class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int v = nums[left] + nums[right];
                if (v > nums[i]) {
                    cnt += right - left;
                    right--;
                } else if (v <= nums[i]){
                    left++;
                }
            }
        }
        return cnt;
    }
}
