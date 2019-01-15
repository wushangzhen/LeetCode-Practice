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
        int n = A.length;
        for (int i = n / 2; i >= 0; i--) {
            helper(i, A);
        }
    }
    void helper(int start, int[] A) {
        while (start < A.length) {
            int son1 = start * 2 + 1;
            int son2 = start * 2 + 2;
            int son = start;
            if (son1 < A.length) {
                if (A[son1] < A[son]) {
                    son = son1;
                }
            }
            if (son2 < A.length) {
                if (A[son2] < A[son]) {
                    son = son2;
                }
            }
            if (son != start) {
                int temp = A[start];
                A[start] = A[son];
                A[son] = temp;
                start = son;
            } else {
                break;
            }
        }
    }
}
