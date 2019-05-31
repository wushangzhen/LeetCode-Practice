class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        while (i < j) {
            res += nums[j] - nums[i];
            j--;
            i++;
        }
        return res;
    }
}
