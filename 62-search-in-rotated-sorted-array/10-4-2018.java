public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int n = A.length;
        int left = 0;
        int right = n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > target && target < A[0] && A[mid] > A[0]) {
                left = mid;
            } else if (A[mid] < target && target >= A[0] && A[mid] < A[0]) { // pay attention to the =;
                right = mid;
            } else if (A[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (A[right] == target) {
            return right;
        }
        if (A[left] == target) {
            return left;
        }
        return -1;
    }
}
