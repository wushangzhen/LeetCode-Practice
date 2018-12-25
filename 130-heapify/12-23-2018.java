public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = (A.length) / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }
    private void siftdown(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2]) {
                son = k * 2 + 2;
            }
            if (A[son] >= A[k]) {
                break;
            }
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }
}
