class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        return quickSelect(0, n - 1, nums, k - 1);
    }
    int quickSelect(int start, int end, int[] A, int k) {
        if (start >= end) {
            return A[start];
        }
        int mid = (start + end) / 2;
        int i = start;
        int j = end;
        int pivot = A[mid];
        while (i <= j) {
            while (i <= j && A[i] > pivot) {
                i++;
            }
            while (i <= j && A[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        }
        if (k <= j) {
            return quickSelect(start, j, A, k);
        }
        if (k >= i) {
            return quickSelect(i, end, A, k);
        }
        return A[k];
    }
}
