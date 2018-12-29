public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = 0; i < A.length; i++) {
            siftUp(A, i);
        }
    }
    void siftUp(int[] A, int index) {
        while (index != 0) {
            int k = (index - 1) / 2;
            if (A[k] > A[index]) {
                int temp = A[k];
                A[k] = A[index];
                A[index] = temp;
                index = k;
            } else {
                break;
            }
        }
    }
}
