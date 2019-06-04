class Solution {
    public boolean validMountainArray(int[] A) {
        int l = 0;
        int r = A.length - 1;
        int n = A.length;
        if (A.length < 3) {
            return false;
        }
        for (; l + 1 < n; l++) {
            if (A[l + 1] <= A[l]) {
                break;
            }
        }
        for (; r > 0; r--) {
            if (A[r - 1] <= A[r]) {
                break;
            }
        }
        System.out.println(l);
        System.out.println(r);
        return l == r && l != 0 && r != n - 1;
    }
}
