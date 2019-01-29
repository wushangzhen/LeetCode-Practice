class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int state = 0;
        for (int i = 0; i < 8; i++) {
            if (cells[i] == 1) {
                state ^= (1 << i);
            }
        }
        Map<Integer, Integer> memo = new HashMap<>();
        while (N > 0) {
            if (memo.containsKey(state)) {
                N %= memo.get(state) - N;
            }
            memo.put(state, N);
            if (N > 0) {
                N--;
                state = nextState(state);
            }
        }
        int[] ans = new int[8];
        for (int i = 0; i <= 7; i++) {
            ans[i] = ((state >> i) & 1);
        }
        return ans;
    }
    int nextState(int state) {
        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                ans |= (1 << i);
            }
        }
        return ans;
        
    }
}
