public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
        double start = 0;
        double end = x;
        if (x < 1) {
            start = 0;
            end = 1;
        }
        while (start + 1e-12 < end) {
            double mid = (start + end) / 2;
            if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end <= x) {
            return end;
        }
        return start;
    }
}
