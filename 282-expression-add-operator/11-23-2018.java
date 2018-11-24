class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dfs(num, 0, "", 0, 0, target, res);
        return res;
    }
    void dfs(String num, int start, String str, long sum, long lastF, int target, List<String> res) {
        if (start > num.length()) {
            return;
        }
        if (start == num.length()) {
            if (sum == target) {
                res.add(str);
            }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            long x = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                dfs(num, i + 1, str + x, x, x, target, res);
            } else {
                dfs(num, i + 1, str + "*" + x, sum - lastF + lastF * x, lastF * x, target, res);
                dfs(num, i + 1, str + "+" + x, sum + x, x, target, res);
                dfs(num, i + 1, str + "-" + x, sum - x, -x, target, res);
            }
            if (x == 0) {
                break;
            }
        }
    }
}
