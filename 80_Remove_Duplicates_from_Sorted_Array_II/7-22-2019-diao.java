class Solution {
    // [0,0,1,1,1,1,2,3,3]
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n != nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
