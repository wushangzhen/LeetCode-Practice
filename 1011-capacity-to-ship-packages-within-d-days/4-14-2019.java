class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        // 注意这个上界 right的寻找
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            int d = helper(weights, mid);
            if (d > D) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (helper(weights, left) <= D) {
            return left;
        }
        return right;
    }
    int helper(int[] weights, int w) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < weights.length; i++) {
            if (count + weights[i] > w) {
                count = 0;
                res++;
            }
            count += weights[i];
        }
        return res + 1;
    }
}
