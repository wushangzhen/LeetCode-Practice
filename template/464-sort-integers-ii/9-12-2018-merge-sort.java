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
        int[] temp = new int[A.length];
        mergeSort(0, A.length - 1, A, temp);
    }
    public void mergeSort(int start, int end, int[] A, int[] temp) {
        if (start >= end) {
            return;
        }  
        int mid = (start + end) / 2;
        mergeSort(start, mid, A, temp);
        mergeSort(mid + 1, end, A, temp);
        merge(start, end, A, temp);
    }
    public void merge(int start, int end, int[] A, int[] temp) {
        int leftIndex = start;
        int index = leftIndex;
        int middle = (start + end) / 2;
        int rightIndex = middle + 1;
        while (leftIndex <= middle && rightIndex <= end) {
            if (A[leftIndex] < A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                temp[index++] = A[rightIndex++];
            }
        }
        while (leftIndex <= middle) {
            temp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }
}
