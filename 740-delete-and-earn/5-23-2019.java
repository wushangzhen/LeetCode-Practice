class Solution {
    public int deleteAndEarn(int[] nums) {
        int N = 10000;
        int[] values = new int[N + 1];
        for (int num : nums) {
            values[num] += num;
        }
        int[] take = new int[N + 1];
        int[] skip = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            skip[i] = Math.max(skip[i - 1], take[i - 1]);
            take[i] = skip[i - 1] + values[i - 1];
        }
        return Math.max(skip[N], take[N]);
    }
}
