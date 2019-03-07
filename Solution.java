class Solution {
    public static int bulbShine(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int count = 0; // represents the number of shine
        int n = nums.length;
        int memo = 0;
        for (int i = 0; i < n; i++) {
            memo = memo | (1 << i);
        }
        for (int i = 0; i < n; i++) {
            if ((memo >> (n - (nums[i] - 1)) == 0)) {
                count++;
            }
            memo = memo ^ (1 << n - (nums[i] - 1) - 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 2, 4};
        System.out.println(Solution.bulbShine(nums));
    }
}
