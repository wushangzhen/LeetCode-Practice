class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            int n = nums2.length;
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2] / 1.0;
            }
        }
        if (nums2 == null || nums2.length == 0) {
            int n = nums1.length;
            if (n % 2 == 0) {
                return (nums1[n / 2 - 1] + nums1[n / 2]) / 2.0;
            } else {
                return nums1[n / 2] / 1.0;
            }
        }
        int n = nums1.length;
        int m = nums2.length;
        int sum = n + m;
        if (sum % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, sum / 2) + findKth(nums1, nums2, 0, 0, sum / 2 + 1)) / 2.0;
        } 
        return findKth(nums1, nums2, 0, 0, sum / 2 + 1) / 1.0;
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
        int halfA = 0;
        int halfB = 0;
        if (startA + kth / 2 - 1 >= A.length) {
            halfA = Integer.MAX_VALUE;
        } else {
            halfA = A[startA + kth / 2 - 1];
        }
        if (startB + kth / 2 - 1 >= B.length) {
            halfB = Integer.MAX_VALUE;
        } else {
            halfB = B[startB + kth / 2 - 1];
        }
        if (halfA < halfB) {
            return findKth(A, B, startA + kth / 2, startB, kth - kth / 2);
        }
        return findKth(A, B, startA, startB + kth / 2, kth - kth / 2);
    }
}
