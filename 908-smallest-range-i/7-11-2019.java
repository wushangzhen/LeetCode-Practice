class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = -1;
        int min = 10001;
        for (int a : A) {
            max = Math.max(a, max);
            min = Math.min(min, a);
        }
        return Math.max(0, max - 2 * K - min);
    }
}
