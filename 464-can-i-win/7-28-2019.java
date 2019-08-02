class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal < 0) {
            return false;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> memo = new HashMap<>();
        return helper(0, maxChoosableInteger, desiredTotal, memo);
    }
    boolean helper(int state, int n, int d, Map<Integer, Boolean> memo) {
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        for (int i = 1; i <= n; i++) {
            if ((state & (1 << i)) != 0) {
                continue;
            }
            if (d <= i || !helper(state | (1 << i), n, d - i, memo)) {
                memo.put(state, true);
                return true;
            }
        }
        memo.put(state, false);
        return false;
    }
}
