class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    bitCount++;
                }
            }
            sum += bitCount * (n - bitCount);
        }
        return sum;
    }
}
