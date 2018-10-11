public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int n = A.length;
        int m = B.length;
        int sum = n + m;
        if (sum == 0) {
            return 0.0;
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (B[m / 2 - 1] + B[m / 2]) / 2.0;
            } else {
                return B[m / 2] / 1.0;
            }
        }
        if (m == 0) {
            if (n % 2 == 0) {
                return (A[n / 2 - 1] + A[n / 2]) / 2.0;
            } else {
                return A[n / 2] / 1.0;
            }
        }
        if (sum % 2 == 0) {
            return (findKth(A, B, 0, 0, sum / 2) + findKth(A, B, 0, 0, sum / 2 + 1)) / 2.0;
        } else {
            return findKth(A, B, 0, 0, sum / 2 + 1); // this is important
            
        }
    }
    int findKth(int[] A, int[] B, int startA, int startB, int k) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }
        if (startB >= B.length) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int halfA = (startA + k / 2 - 1) < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfB = (startB + k / 2 - 1) < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if (halfA < halfB) {
            return findKth(A, B, startA + k / 2, startB, k - k / 2);
        }
        return findKth(A, B, startA, startB + k / 2, k - k / 2);
        
    }
}
