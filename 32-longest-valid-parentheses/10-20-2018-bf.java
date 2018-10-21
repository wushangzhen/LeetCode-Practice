class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                continue;
            }
            for (int j = i + 1; j <= s.length(); j++) {
                if (isValid(s.substring(i, j))) {
                    if (max < j - i) {
                        max = j - i;
                    }
                }
            }
        }
        return max;
    }
    boolean isValid(String str) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stk.push(c);
            } else {
                if (stk.size() == 0) {
                    return false;
                }
                stk.pop();
            }
        }
        return stk.size() == 0;
    }
}
