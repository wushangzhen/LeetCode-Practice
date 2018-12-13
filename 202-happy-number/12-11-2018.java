class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            n = cal(n);
            if (set.contains(n)) {
                break;
            }
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
    int cal(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
