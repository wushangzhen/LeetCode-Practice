class Solution {
    // [0,1,0,3,12]
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int p1 = 0; // point zero
        int p2 = 0; // point non zero
        int n = nums.length;
        while (p1 < n && p2 < n) {
            while (p1 < n && nums[p1] != 0) {
                p1++;
                continue;
            }
            while (p2 < n && nums[p2] == 0) {
                p2++;
                continue;
            }
            if (p1 < n && p2 < n && p1 < p2) {
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
                
            }
            p2++;
        }
    }
}
