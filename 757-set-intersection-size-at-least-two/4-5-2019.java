class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->(a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));
        Stack<int[]> stk = new Stack<>();
        for (int[] interval : intervals) {
            while (!stk.isEmpty() && stk.peek()[1] >= interval[1]) {
                stk.pop();
            }
            stk.push(interval);
        }
        int n = stk.size();
        int[][] a = new int[n][2];
        for (int i = n - 1; i >= 0; i--) {
            a[i][0] = stk.peek()[0];
            a[i][1] = stk.pop()[1];
        }
        int ans = 2;
        int p1 = a[0][1] - 1;
        int p2 = a[0][1];
        for (int i = 1; i < n; i++) {
            boolean b1 = (p1 >= a[i][0] && p1 <= a[i][1]);
            boolean b2 = (p2 >= a[i][0] && p2 <= a[i][1]);
            if (b1 && b2) {
                continue;
            } else if (b2) {
                p1 = p2;
                p2 = a[i][1];
                ans++;
            } else {
                p1 = a[i][1] - 1;
                p2 = a[i][1];
                ans += 2;
            }
        }
        return ans;
    }
}
