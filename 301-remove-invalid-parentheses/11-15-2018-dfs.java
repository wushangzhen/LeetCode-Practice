public class Solution {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        char[] sc = s.toCharArray();
        int cnt1 = 0;
        int cnt2 = 0;
        for (char c : sc) {
            if (c == '(') {
                cnt1++;
            }
            if (c == ')') {
                if (cnt1 != 0) {
                    cnt1--;
                } else {
                    cnt2++;
                }
            }
        }
        helper(0, s, cnt1, cnt2, res);
        return res;
    }
    void helper(int start, String s, int cnt1, int cnt2, List<String> res) {
        if (cnt1 == 0 && cnt2 == 0) {
            if (isValid(s)) {
                res.add(s);
                return;
            }
        }
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i - 1) == s.charAt(i)) {
                continue;
            }
            if (cnt1 > 0 && s.charAt(i) == '(') {
                helper(i, s.substring(0, i) + s.substring(i + 1), cnt1 - 1, cnt2, res);
            }
            if (cnt2 > 0 && s.charAt(i) == ')') {
                helper(i, s.substring(0, i) + s.substring(i + 1), cnt1, cnt2 - 1, res);
            }
        }
    }
    boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (count < 0) {
                return false;
            }
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
        }
        return count == 0;
    }
}
