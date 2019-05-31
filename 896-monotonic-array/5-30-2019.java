class Solution {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        int i = 1;
        while (i < n) {
            if (A[i] > A[i - 1]) {
                break;
            }
            i++;
        }
        if (i == n) {
            return true;
        }
        i = 1;
        while (i < n) {
            if (A[i] < A[i - 1]) {
                break;
            }
            i++;
        }
        if (i == n) {
            return true;
        }
        return false;
    }
}
