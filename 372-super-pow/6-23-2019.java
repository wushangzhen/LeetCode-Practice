class Solution {
    int mod = 1337;
    public int superPow(int a, int[] b) {
        int n = b.length - 1;
        return helper(a, b, n);
    }
    int helper(int a, int[] b, int n) {
        if (n < 0) {
            return 1;
        }
        return pow(helper(a, b, n - 1), 10) * pow(a, b[n]) % mod;
    }
    int pow(int a, int k) {
        a %= mod;
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = (res * a) % mod;
        }
        return (int) res;
    }
    
}
