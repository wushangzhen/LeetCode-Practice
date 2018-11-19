class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int i = 25;
        int mx = count[i];
        int len = tasks.length;
        while (i >= 0 && count[i] == mx) {
            i--;
        }
        return Math.max((mx - 1) * (n + 1) + 25 - i, len);
    }
}
