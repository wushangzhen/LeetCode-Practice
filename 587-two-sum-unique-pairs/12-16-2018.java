public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int cnt = 0;
        while (left < right) {
            if (left != 0 && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                right--;
                continue;
            }
            int v = nums[left] + nums[right];
            if (v == target) {
                cnt++;
                left++;
                right--;
            } else if (v < target) {
                left++;
            } else {
                right--;
            }
        }
        return cnt;
    }
}
