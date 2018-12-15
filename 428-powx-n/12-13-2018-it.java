class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        double ans = 1;
        double product = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * product;
            }
            product *= product;
        }
        return ans;
    }
}
