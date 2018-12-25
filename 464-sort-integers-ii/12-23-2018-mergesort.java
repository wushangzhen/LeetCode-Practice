public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    int[] temp;
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        int n = A.length;
        temp = new int[n];
        mergeSort(0, n - 1, A);
    }
    void mergeSort(int start, int end, int[] A) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(start, mid, A);
        mergeSort(mid + 1, end, A);
        merge(start, end, A);
    }
    void merge(int start, int end, int[] A) {
        if (start >= end) {
            return;
        }
        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        for (int i = start; i <= end; i++) {
            temp[i] = A[i];
        }
        int k = start;
        while (left <= mid && right <= end) {
            if (temp[left] < temp[right]) {
                A[k++] = temp[left++];
            } else {
                 A[k++] = temp[right++];
            }
        }
        while (left <= mid) {
            A[k++] = temp[left++];
        }
        while (right <= end) {
            A[k++] = temp[right++];
        }
    }
}
