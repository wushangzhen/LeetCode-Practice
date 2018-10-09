public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return 0.0;
        }
        int n = A.length;
        int m = B.length;
        int sum = m + n;
        if (sum % 2 == 0) {
            return (findKth(A, B, 0, 0, sum / 2) 
            + findKth(A, B, 0, 0, sum / 2 + 1)) / 2.0;
        }
        return findKth(A, B, 0, 0, sum / 2 + 1) / 1.0;
    }
    int findKth(int[] A, int[] B, int startA, int startB, int kth) {
        if (startA >= A.length) {
            return B[startB + kth - 1];
        }
        if (startB >= B.length) {
            return A[startA + kth - 1];
        }
        
        if (kth == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int halfOfKthA = startA + kth / 2 - 1 < A.length ? A[startA + kth / 2 - 1] :
            Integer.MAX_VALUE;
        int halfOfKthB = startB + kth / 2 - 1 < B.length ? B[startB + kth / 2 - 1] :
            Integer.MAX_VALUE;
        if (halfOfKthA < halfOfKthB) {
            return findKth(A, B, startA + kth / 2, startB, kth - kth / 2);
        }
        return findKth(A, B, startA, startB + kth / 2, kth - kth / 2);
    }
    
}
