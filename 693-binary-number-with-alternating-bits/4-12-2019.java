class Solution {
    public boolean hasAlternatingBits(int n) {
        int cur = 0;
        cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) {
                return false;
            }
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
}
