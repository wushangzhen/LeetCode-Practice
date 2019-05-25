class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        int pos = 0, neg = 0, pos2 = 0, neg2 = 0, k = 0;
        while (target > 0) {
            int m = target % x;
            target /= x;
            if (k > 0) {
                pos2 = Math.min(m * k + pos, (m + 1) * k + neg);
                neg2 = Math.min((x - m) * k + pos, (x - m) * k + k + neg - 2 * k);
                pos = pos2;
                neg = neg2;
            } else {
                pos = m * 2;
                neg = (x - m) * 2;
            }
            k++;
        }
        return Math.min(pos - 1, k + neg - 1);
    }
}
