public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        Arrays.sort(L);
        long sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i];
        }
        int min = L[0];
        int len = L.length;
        int max = L[len - 1];
        if (k > sum || k < 0) {
            return 0;
        }
        int left = 1;
        int right = max;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int n = 0;
            for (int i = 0; i < L.length; i++) {
                n += (L[i] / mid);
            }
            if (n >= k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int n = 0;
        int m = 0;
        for (int i = 0; i < L.length; i++) {
            n += (L[i] / left);
            m += (L[i] / right);
        }
        if (m >= k) { // > is necessary because we k may not be created
            return right;
        } 
        if (n >= k) {
            return left;
        }
        return 0;
    }
}
