class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        int same = 0;
        int diff = k;
        for (int i = 2; i <= n; i++) {
            int temp = diff;
            diff = same * (k - 1) + diff * (k - 1);
            same = temp;
        }
        return same + diff;
    }
}
