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
        if (start == s.length() && n == 4) {
            res.add(str.substring(0, str.length() - 1));
            return;
        }
        if (start >= s.length()) {
            return;
        }
        if (0 < s.charAt(start) - '0' && s.charAt(start) - '0' <= 2) {
            if (start + 1 < s.length() && 
                (s.charAt(start) - '0' < 2 || (s.charAt(start) - '0' == 2 && s.charAt(start + 1) - '0' < 6))) {
                if (start + 2 < s.length() && 
                    (s.charAt(start + 1) - '0' < 5 
                        || (s.charAt(start + 1) == '5' && s.charAt(start + 2) - '0' < 6))) {
                    String ss = s.substring(start, start + 3);
                    System.out.println(ss);
                    helper(start + 3, str + ss + '.', s, res, n + 1);
                }
            }
        }
        for (int i = 1; i <= 2 && start + i <= s.length(); i++) {
            if (i == 2 && s.charAt(start) == '0') {
                continue;
            }
            String ss = s.substring(start, start + i);
            helper(start + i, str + ss + '.', s, res, n + 1);
        }
    }
}
