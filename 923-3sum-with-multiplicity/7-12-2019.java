class Solution {
    public int threeSumMulti(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        long[] memo = new long[101];
        for (int a : A) {
            memo[a]++;
        }
        long res = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = i; j < 101; j++) {
                int k = target - i - j;
                // remove the duplicates
                // * may overflow so have to use long type
                if (k < 0 || k > 100) {
                    continue;
                }
                if (i == j && j == k) {
                    res += memo[i] * (memo[i] - 1) * (memo[i] - 2) / 6;
                } else if (i == j && k != j) {
                    res += memo[i] * (memo[i] - 1) * memo[k] / 2; 
                } else if (k > j) {
                    res += memo[i] * memo[k] * memo[j];
                }
            }
        }
        return (int)(res % (1e9 + 7));
    }
}
