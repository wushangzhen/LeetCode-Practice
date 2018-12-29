public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = A.length / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }
    void siftDown(int[] A, int index) {
        while (index < A.length) {
            int k = index;
            int son1 = index * 2 + 1;
            int son2 = index * 2 + 2;
            if (son1 < A.length && A[son1] < A[k]) {
                k = son1;
            }
            if (son2 < A.length && A[son2] < A[k]) {
                k = son2;
            }
            if (k != index) {
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
