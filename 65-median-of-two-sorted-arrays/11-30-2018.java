class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int sum = n + m;
        if (sum % 2 == 0) {
            return (findKth(0, 0, nums1, nums2, sum / 2) + findKth(0, 0, nums1, nums2, sum / 2 + 1)) / 2.0;
        } else {
            return findKth(0, 0, nums1, nums2, sum / 2 + 1) / 1.0;
        }
    }
    int findKth(int startA, int startB, int[] nums1, int[] nums2, int kth) {
        if (startA >= nums1.length) {
            return nums2[startB + kth - 1];
        }
        if (startB >= nums2.length) {
            return nums1[startA + kth - 1];
        }
        if (kth == 1) {
            return Math.min(nums1[startA], nums2[startB]);
        }
        int halfA = Integer.MAX_VALUE;
        int halfB = Integer.MAX_VALUE;
        if (startA + kth / 2 - 1 < nums1.length) {
            halfA = nums1[startA + kth / 2 - 1];
        }
        if (startB + kth / 2 - 1 < nums2.length) {
            halfB = nums2[startB + kth / 2 - 1];
        }
        if (halfA > halfB) {
            return findKth(startA, startB + kth / 2, nums1, nums2, kth - kth / 2);
        } else {
            return findKth(startA + kth / 2, startB, nums1, nums2, kth - kth / 2);
        }
    }
}
