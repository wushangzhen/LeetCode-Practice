class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int res = 0;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss = miss + nums[i++];
            } else {
                miss += miss;
                ++res;
            }
        }
        return res;
    }
}
