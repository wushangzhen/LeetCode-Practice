class Solution {
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] leftMax = new int[n + 1];
        int[] rightMin = new int[n + 1];
        rightMin[n] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            leftMax[i] = Math.max(A[i - 1], leftMax[i - 1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(A[i], rightMin[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            if (leftMax[i] <= rightMin[i]) {
                return i;
            }
        }
        return -1;
    }
}
