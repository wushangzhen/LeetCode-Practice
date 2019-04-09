class Solution {
    public String findContestMatch(int n) {
        String[] team = new String[n];
        for (int i = 0; i < n; i++) {
            team[i] = String.valueOf(i + 1);;
        }
        while (n > 0) {
            for (int i = 0; i < n / 2; i++) {
                team[i] = "(" + team[i] + "," + team[n - i - 1] + ")";
            }
            n /= 2;
        }
        return team[0];
    }
}
