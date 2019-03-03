class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += count(i);
        }
        return res;
    }
    int count(int x) {
        if (x == 1) {
            return 10;
        }
        int res = 1;
        for (int i = 9; i >= (11 - x); i--) {
            res = res * i;
        }
        return res * 9;
    }
}
