class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(0, "", s, res, 0);
        return res;
    }
    void dfs(int start, String str, String s, List<String> res, int count) {
        if (count > 4) {
            return;
        }
        if (start == s.length()) {
            if (count == 4) {
                res.add(str.substring(0, str.length() - 1));
            }
            return;
        }
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            if (s.charAt(start) == '0') {
                dfs(start + i, str + s.substring(start, start + i) + ".", s, res, count + 1);
                break;
            } else {
                String temp = s.substring(start, start + i);
                if (Integer.parseInt(temp) < 256) {
                    dfs(start + i, str + temp + ".", s, res, count + 1);
                }
            }
        }
    }
}
