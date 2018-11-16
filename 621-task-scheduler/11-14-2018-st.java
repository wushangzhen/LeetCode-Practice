class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int i = 25; 
        int mx = map[i];
        int len = tasks.length;
        while (i >= 0 && map[i] == mx) {
            i--;
        }
        return Math.max(len, (mx - 1) * (n + 1) + 25 - i);
    }
}
