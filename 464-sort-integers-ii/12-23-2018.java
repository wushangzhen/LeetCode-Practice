public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        int n = A.length;
        quickSort(0, n - 1, A);
    }
    void quickSort(int start, int end, int[] A) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int mid = (start + end) / 2;
        int pivot = A[mid];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(start, right, A);
        quickSort(left, end, A);
    }
}
