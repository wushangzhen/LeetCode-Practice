class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int up = 0;
        int down = 0;
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if ((down > 0 && A[i] > A[i - 1]) || A[i] == A[i - 1]) {
                up = 0;
                down = 0;
            }
            if (A[i] > A[i - 1]) {
                up++;
            } 
            if (A[i - 1] > A[i]) {
                down++;
            }
            if (up > 0 && down > 0 && up + down + 1 > res) {
                res = up + down + 1;
            }
        }
        return res;
    }
}
