class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int left = 0;
        for (; left < temp.length; left++) {
            if (temp[left] != nums[left]) {
                break;
            }
        }
        int right = temp.length - 1;
        for (; right >= 0; right--) {
            if (temp[right] != nums[right]) {
                break;
            }
        }
        return left < right ? right - left + 1 : 0;
    }
}
