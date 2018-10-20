class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        boolean isNeg = false;
        long temp = 0;
        if (x < 0) {
            isNeg = true;
            temp = Math.abs((long)x);
        } else {
            temp = x;
        }
        long result = 0;
        while (temp != 0) {
            result = result * 10 + temp % 10;
            temp /= 10;
        }
        if (isNeg) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;    
        }
        return (int) result;
    }
}
