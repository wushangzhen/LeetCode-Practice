class Solution {
    // count the trust and trusted numbers
    public int findJudge(int N, int[][] trust) {
        int[] trusts = new int[N + 1];
        int[] trusteds = new int[N + 1];
        for (int[] t : trust) {
            trusts[t[0]]++;
            trusteds[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (trusts[i] == 0 && trusteds[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
