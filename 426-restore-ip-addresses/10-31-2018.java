class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(0, "", s, res, 0);
        return res;
    }
    void helper(int start, String str, String s, List<String> res, int n) {
        if (n > 4) {
            return;
        }
        if (start == s.length() && n == 4) {
            res.add(str.substring(0, str.length() - 1));
            return;
        }
        if (start >= s.length()) {
            return;
        }
        for (int ch = 1; ch <= 3 && start + ch <= s.length(); ch++) {
            String temp = s.substring(start, start + ch);
            if (ch > 1 && temp.startsWith("0")) {
                continue;
            }
            int num = Integer.parseInt(temp);
            if (num >= 0 && num < 256) {
                helper(start + ch, str + temp + ".", s, res, n + 1);
            }
        }
    }
}
