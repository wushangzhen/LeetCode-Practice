class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        if (n == 0) {
            return res;
        }
        int left = 0;
        int right = n - 1;
        int t = n - 1;
        while (left <= right) {
            if (Math.abs(A[left]) < Math.abs(A[right])) {
                res[t--] = A[right] * A[right];
                right--;
            } else {
                res[t--] = A[left] * A[left];
                left++;
            }
        }
        return res;
    }
}
