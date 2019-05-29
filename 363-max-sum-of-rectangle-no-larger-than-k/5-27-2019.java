class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int sum = Integer.MIN_VALUE;
        for (int left = 0; left < m; left++) {
            int[] nums = new int[n];
            for (int right = left; right < m; right++) {
                for (int i = 0; i < n; i++) {
                    nums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int curSum = 0;
                for (int num : nums) {
                    curSum += num;
                    Integer upper = set.ceiling(curSum - k);
                    if (upper != null) {
                        sum = Math.max(sum, curSum - upper);
                    }
                    set.add(curSum);
                }
            }
        }
        return sum;
    }
}
