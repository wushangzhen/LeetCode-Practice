class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int[] memo = new int[26];
        int len = tasks.length;
        for (int i = 0; i < len; i++) {
            memo[tasks[i] - 'A']++;
        }
        Arrays.sort(memo);
        int i = 25;
        int mx = memo[25];
        while (i >= 0 && mx == memo[i]) {
            i--;
        }
        return Math.max(len,  (mx - 1) * (n + 1)  + 26 - i - 1);
        
    }
}
