class Solution {
    Integer[] memo;
    Set<Integer> set;
    int[] costs;
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int m = costs.length;
        this.costs = costs;
        set = new HashSet<>();
        memo = new Integer[366];
        for (int day : days) {
            set.add(day);
        }
        return dp(1);
    }
    int dp(int day) {
        if (day > 365) {
            return 0;
        }
        if (memo[day] != null) {
            return memo[day];
        }
        int ans = 0;
        if (set.contains(day)) {
            ans = Math.min(dp(day + 1) + costs[0], dp(day + 7) + costs[1]);
            ans = Math.min(dp(day + 30) + costs[2], ans);
        } else {
            ans = dp(day + 1);
        }
        memo[day] = ans;
        return ans;
    }
}
