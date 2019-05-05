class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return true;
        }
        long l = 1;
        long r = num / 2;
        while (l + 1 < r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (l * l == num || r * r == num) {
            return true;
        }
        return false;
    }
}
