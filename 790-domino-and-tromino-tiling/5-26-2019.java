class Solution {
    public int numTilings(int N) {
        long [] g = new long[1001];
        long [] u = new long[1001];
        int mod = 1_000_000_007;
        g[0] = 0;
        g[1] = 1;
        g[2] = 2;
        u[0] = 0;
        u[1] = 1;
        u[2] = 2;
        for (int i = 3; i <= N; i++) {
            u[i] = (u[i - 1] + g[i - 1]) % mod;
            g[i] = (2 * u[i - 2] + g[i - 1] + g[i - 2]) % mod;
        }
        return (int)g[N];
    }
}
