class Solution {
    boolean isFound = false;
    List<Integer> ans = new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(0, -1, -1, S, res);
        return ans;
    }
    void dfs(int start, long first, long second, String S, List<Integer> res) {
        if (isFound) {
            return;
        }
        if (start == S.length() && first != -1 && second != -1 && res.size() >= 3) {
            ans = new ArrayList<>(res);
            isFound = true;
            return;
        }
        for (int i = start + 1; i <= S.length(); i++) {
            String la = S.substring(start, i);
            if (la.startsWith("0") && la.length() != 1) {
                continue;
            }
            if (la.length() == 0) {
                continue;
            }
            long temp = Long.parseLong(la);
            if (temp >= Integer.MAX_VALUE) {
                break; // 这个是必须的，因为要停止继续，有可能会超过long的限制，这样相当于剪枝
            }
            if (first == -1 || second == -1 || first + second == temp) {
                res.add((int)temp);
                dfs(i, second, temp, S, res);
                res.remove(res.size() - 1);
            }
        }
    }
}
