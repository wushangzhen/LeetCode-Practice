class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int f = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            f += i * A[i];
            sum += A[i];
        }
        int max = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * A[n - i];
            max = Math.max(f, max);
        }
        return max;
    }
}
