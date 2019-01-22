class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int sum = n + m;
        if (sum % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, sum / 2) + findKth(nums1, nums2, 0, 0, sum / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, nums2, 0, 0, sum / 2 + 1) / 1.0;
        }
    }
    int findKth(int[] nums1, int[] nums2, int index1, int index2, int kth) {
        if (index1 >= nums1.length) {
            return nums2[index2 + kth - 1];
        }
        if (index2 >= nums2.length) {
            return nums1[index1 + kth - 1];
        }
        if (kth == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }
        int midA = index1 + kth / 2 - 1;
        int midB = index2 + kth / 2 - 1;
        int halfA = Integer.MAX_VALUE;
        int halfB = Integer.MAX_VALUE;
        if (midA < nums1.length) {
            halfA = nums1[midA];
        }
        if (midB < nums2.length) {
            halfB = nums2[midB];
        }
        if (halfA < halfB) {
            return findKth(nums1, nums2, midA + 1, index2, kth - kth / 2);
        } else {
            return findKth(nums1, nums2, index1, midB + 1, kth - kth / 2);
        }
        
    }
}
