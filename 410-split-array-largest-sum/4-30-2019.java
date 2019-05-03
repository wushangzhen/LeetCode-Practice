class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int total = 0;
        for (int n : nums) {
            max = Math.max(n, max);
            total += n;
        }
        int l = max;
        int r = total;
        while (l + 1 < r) {
            int mid = (l - r) / 2 + r;
            if (valid(nums, m, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (valid(nums, m, l)) {
            return l;
        }
        return r;
    }
    boolean valid(int[] nums, int m, int target) {
        int sum = 0;
        int num = 1;
        for (int n : nums) {
            if (sum + n > target) {
                sum = n;
                num++;
                if (num > m) {
                    return false;
                }
            } else {
                sum += n;
            }
        }
        return true;
    }
}
