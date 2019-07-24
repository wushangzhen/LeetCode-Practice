class Solution {
    // [0,0,1,1,1,1,2,3,3]
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            count = 0;
            int temp = nums[r];
            while (r < nums.length && nums[r] == temp) {
                count++;
                r++;
            }
            if (count >= 2) {
                for (int i = 0; i <= 1; i++) {
                    nums[l + i] = temp;
                }
                l += 2;
            } else {
                nums[l++] = temp;
            }
        }
        return l;
    }
}
