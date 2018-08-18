class Solution {
public:
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    double findMedianSortedArrays(vector<int> &A, vector<int> &B) {
        // write your code here
        int lenA = A.size();
        int lenB = B.size();
        int lenSum = lenA + lenB;
        if ((lenSum) % 2 == 0) {
            return (findKthNumber(A, B, lenSum / 2) + findKthNumber(A, B, lenSum / 2 + 1)) / 2.0;
        }
        return findKthNumber(A, B, lenSum / 2 + 1);
    }
    int findKthNumber(vector<int> &A, vector<int> &B, int number) {
        if (A.size() == 0) {
            return B[number - 1];
        }
        if (B.size() == 0) {
            return A[number - 1];
        }
        int start = std::min(A[0], B[0]);
        int end = std::max(A[A.size() - 1], B[B.size() - 1]);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((countNumberInArray(A, mid) + countNumberInArray(B, mid)) < number) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if ((countNumberInArray(A, start) + countNumberInArray(B, start)) == number) {
            return start;
        } else {
            return end;
        }
    }
    int countNumberInArray(vector<int>& nums, int number) {
        int start = 0;
        int end = nums.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= number) {
                start = mid;    
            } else {
                end = mid;
            }
        }
        if (nums[start] > number) {
            return start;
        }
        if (nums[end] > number) {
            return end;
        }
        return nums.size();
    } 
};
