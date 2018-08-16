class Solution {
public:
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    void siftUp(vector<int>& A, int i) {
        while (i != 0) {
            int father = (i - 1) / 2;
            if (A[father] < A[i]) {
                break;
            }
            int temp = A[i];
            A[i] = A[father];
            A[father] = temp;
            i = father;
        }
    }
    void heapify(vector<int> &A) {
        // write your code here
        for (int i = 0; i < A.size(); i++) {
            siftUp(A, i);
        }
    }
};
// The time complexity is O(nlogn), we have to traverse all the nodes and every
// nodes will cost O(logn)(The trees depth) at most
