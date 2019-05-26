class Solution {
    public int[] prevPermOpt1(int[] A) {
        int j = A.length - 2;
        while (j >= 0) {
            if (A[j + 1] >= A[j]) {
                j--;
            } else {
                break;
            }
        }
        if (j == -1) {
            return A;
        }
        int i = A.length - 1;
        while (i > j) {
            if (A[i] < A[j]) {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                break;
            }
            i--;
        }
        return A;
        
    }
}
