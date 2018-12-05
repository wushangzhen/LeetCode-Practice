class Solution {
    int[] helper;
    public int reversePairs(int[] A) {
        helper = new int[A.length];
        int sum = mergeSort(A, 0, A.length - 1);
        return sum;
    }
    
    private int mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }
        
        int mid = (start + end) / 2;
        int sum = 0;
        sum += mergeSort(A, start, mid);
        sum += mergeSort(A, mid+1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && A[i] > 2 * (long) A[j]) {
                j++;
            }
            sum += j - mid - 1;
        }
        //Arrays.sort(A, start, end + 1);
        merge(A, start, mid, end);
        //sum += merge(A, start, mid, end);
        return sum;
    }
    
    private void merge(int[] A, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            helper[i] = A[i];
        }
        int p1 = start;
        int p2 = mid + 1;
        int i = start;
        while(p1 <= mid || p2 <= end){
            if (p1 > mid || (p2 <= end && helper[p1] >= helper[p2])){
                A[i++] = helper[p2++];
            } else {
                A[i++] = helper[p1++];
            }
        }
        
    }
}
