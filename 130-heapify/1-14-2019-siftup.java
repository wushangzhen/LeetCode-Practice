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
        for (int i = 0; i < A.length; i++) {
            helper(i, A);
        }
    }
    void helper(int start, int[] A) {
        while (start != 0) {
            int father = (start - 1) / 2;
            if (A[start] > A[father]) {
                break;
            }
            int temp = A[start];
            A[start] = A[father];
            A[father] = temp;
            start = father;
        }
    }
}
