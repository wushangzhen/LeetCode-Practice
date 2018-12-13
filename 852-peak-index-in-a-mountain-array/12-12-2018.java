class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1]) {
                left = mid;
            }
            if (A[mid] > A[mid + 1]) {
                right = mid;
            }
        }
        return A[left] < A[right] ? right : left;
    }
}
