class Solution {
    // using pairs 
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 2; // necessary
            }
        }
        if (start != 0 && nums[start] == nums[start - 1] || end == nums.length - 1) {
            return nums[end];
        }
        return nums[start];
    }
}
