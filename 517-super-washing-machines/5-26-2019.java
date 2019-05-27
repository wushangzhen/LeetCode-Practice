class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int[] preSum = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += machines[i];
            preSum[i + 1] = sum;
        }
        if (sum % n != 0) {
            return -1;
        }
        int avg = sum / n;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int l = i * avg - preSum[i] + preSum[0];
            int r = (n - i - 1) * avg - preSum[n] + preSum[i + 1];
            if (l > 0 && r > 0) {
                max = Math.max(Math.abs(l) + Math.abs(r), max);
            } else {
                max = Math.max(Math.max(Math.abs(l), Math.abs(r)), max);
            }
        }
        return max;
    }
}
