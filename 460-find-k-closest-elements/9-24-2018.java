public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int[] result = new int[k];
        if (A == null || A.length == 0) {
            return result;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        for (int i = 0; i < k; i++) {
            if (start >= 0 && end < A.length) {
                if (Math.abs(A[start] - target) > Math.abs(A[end] - target)) {
                    result[i] = A[end];
                    end++;
                } else {
                    result[i] = A[start];
                    start--;
                }
            } else {
                if (start != -1) {
                    result[i] = A[start];
                    start--;
                }
                if (end != A.length) {
                    result[i] = A[end];
                    end++;
                }
            }
        }
        return result;
    }
}
