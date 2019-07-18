class Solution {
    public int myAtoi(String str) {
        String temp = str.trim();
        if (temp.length() == 0) {
            return 0;
        }
        char c = temp.charAt(0);
        int n = temp.length();
        long res = 0;
        int sign = 1;
        int i = 0;
        if (check(c) || c == '-' || c == '+') {
            if (c == '-') {
                sign = -1;
                i = 1;
            } else if (c == '+') {
                i = 1;
            } else {
                i = 0;
            }
            while (i < n && temp.charAt(i) == '0') {
                i++;
            }
            while (i < n && check(temp.charAt(i))) {
                res = res * 10 + temp.charAt(i++) - '0';
                if (res > Integer.MAX_VALUE) {
                    break;
                }
            }
        }
        res *= sign;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
    boolean check(char c) {
        return '0' <= c && c <= '9';
    }
}
