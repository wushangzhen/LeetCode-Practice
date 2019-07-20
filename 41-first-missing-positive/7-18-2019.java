class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            while (A[i] <= n && A[i] > 0 && A[A[i] - 1] != A[i]) { // while is important, so that i will always be places right num
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
