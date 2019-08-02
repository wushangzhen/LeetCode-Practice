class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = 0;
        int[] P = {1, -1};
        for (int p : P) {
            for (int q : P) {
                int min = p * arr1[0] + q * arr2[0] + 0;
                for (int i = 1; i < arr1.length; i++) {
                    int cur = p * arr1[i] + q * arr2[i] + i;
                    res = Math.max(res, cur - min);
                    min = Math.min(cur, min);
                }
            }
        }
        return res;
    }
}
