public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        for (int i = 0; i < A.length; i++) {
            siftUp(i, A);
        }
    }
    void siftUp(int k, int[] A) {
        int father = (k - 1) / 2; // this is important
        while (k != 0) {
            if (A[k] > A[father]) {
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;
            k = father;
        }
    }
}
public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftDown(i, A);
        }
    }
    void siftDown(int k, int[] A) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[son]) {
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
