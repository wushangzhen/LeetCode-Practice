class Solution {
public:
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    void siftDown(vector<int>& A, int i) {
        while (i * 2 + 1 < A.size()) {
            int son = i * 2 + 1;
            if (2 * i + 2 < A.size() && A[son] > A[2 * i + 2]) {
                son = 2 * i + 2;
            }
            if (A[son] >= A[i]) {
                break;
            }
            int temp = A[i];
            A[i] = A[son];
            A[son] = temp;
            i = son;
        }
    }
    void heapify(vector<int> &A) {
        // write your code here
        for (int i = (A.size() - 1) / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }
};
// O(n)
