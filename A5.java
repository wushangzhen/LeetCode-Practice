class A5 {
    double function(int ii, int jj, int n) {
        int a = n - ii;
        int b - n - jj;
        if (a == 0) {
            return 1;
        }
        if (b == 0) {
            return 0;
        }
        double[][] dp = new double[a][b];
        for (int d = 1; d < a + b; d++) {
            for (int i = 0; i < a && i < d; i++) {
                if (i > 0) {
                    dp[i][d - i] += dp[i - 1][d - i] * 0.5; // a wins
                } else if (d - i > 0) {
                    dp[i][d - i] += dp[i][d - i - 1] * 0.5;
                }
            }
        }
        double sum = 0;
        for (int i = 0; i < b - 1; i++) {
            sum += dp[a - 1][i];
        }
        return sum; 
    }
}
