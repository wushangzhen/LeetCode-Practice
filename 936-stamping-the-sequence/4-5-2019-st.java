class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] sc = stamp.toCharArray();
        char[] tc = target.toCharArray();
        int stars = 0;
        int n = tc.length;
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        while (stars < n) {
            boolean doneReplace = false;
            for (int i = 0; i <= n - sc.length; i++) {
                if (!visited[i] && canReplace(i, sc, tc)) {
                    stars += doReplace(i, sc, tc);
                    visited[i] = true;
                    res.add(i);
                    doneReplace = true;
                    if (stars == n) {
                        break;
                    }
                }
            }
            if (!doneReplace) {
                return new int[0];
            }
        }
        int m = res.size();
        int[] ans = new int[m];
        int index = 0;
        for (int i = m - 1; i >= 0; i--) {
            ans[index++] = res.get(i);
        }
        return ans;
    }
    boolean canReplace(int index, char[] sc, char[] tc) {
        for (int i = 0; i < sc.length; i++) {
            if (tc[index + i] != '*' && tc[index + i] != sc[i]) {
                return false;
            }
        }
        return true;
    }
    int doReplace(int index, char[] sc, char[] tc) {
        int star = 0;
        for (int i = 0; i < sc.length; i++) {
            if (tc[i + index] != '*') {
                tc[i + index] = '*';
                star++;
            }
        }
        return star;
    }
}
