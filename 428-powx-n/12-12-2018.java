class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return x;
        }
        long temp = (long) n;
        if (temp < 0) {
            x = 1 / x;
            temp = -temp;
        }
        return fastPower(x, temp);
    }
    double fastPower(double x, long n) {
        if (n == 1) {
            return x;
        }
        double res = 1.0;
        double temp = fastPower(x, n / 2);
        res *= temp * temp;
        if (n % 2 == 1) {
            res *= x;
        }
        return res;
    }
}
