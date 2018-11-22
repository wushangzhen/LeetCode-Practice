class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add(s);
            return res;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        int n = s.length();
        char[] sc = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (sc[i] == '(') {
                cnt1++;
            } else if (sc[i] == ')') {
                if (cnt1 > 0) {
                    cnt1--;
                } else {
                    cnt2++;
                }
            }
        }
        helper(0, cnt1, cnt2, s, res);
        return res;
    }
    void helper(int start, int cnt1, int cnt2, String s, List<String> res) {
        if (cnt1 == 0 && cnt2 == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        } 
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (cnt1 > 0 && s.charAt(i) == '(') {
                helper(i, cnt1 - 1, cnt2, s.substring(0, i) + s.substring(i + 1), res);
            }
            if (cnt2 > 0 && s.charAt(i) == ')') {
                helper(i, cnt1, cnt2 - 1, s.substring(0, i) + s.substring(i + 1), res);
            }
        }
    }
    boolean isValid(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (right >= left) {
                    return false;
                }
                right++;
            }
        }
        return left == right;
    }
}
