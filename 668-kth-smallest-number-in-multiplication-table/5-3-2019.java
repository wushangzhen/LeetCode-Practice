class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int r = m * n;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (helper(m, n, k, mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (!helper(m, n, k, l)) {
            return r;
        } else {
            return l;
        }
    }
    public boolean helper(int m, int n, int k, int x) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }
}
