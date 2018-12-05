public class Solution {
    /**
     * @param A: an array
     * @return: total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return (long) 0;
        }
        return mergeSort(0, A.length - 1, A);
    }
    
    int mergeSort(int start, int end, int[] A) {
        if (start >= end) {
            return 0;
        }
        int sum = 0;
        int mid = (start + end) / 2;
        sum += mergeSort(start, mid, A);
        sum += mergeSort(mid + 1, end, A);
        sum += merge(start, end, A);
        return sum;
    }
    int merge(int start, int end, int[] A) {
        int[] temp = new int[A.length];
        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        int sum = 0;
        int index = start;
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                temp[index++] = A[left++]; 
            } else {
                sum += mid - left + 1;
                temp[index++] = A[right++]; 
            }
        }
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
        return sum;
    }
}
