class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            int zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) {
                    break;
                } else if ((num & (1 << i)) != 0) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            if (ones > zeros) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
