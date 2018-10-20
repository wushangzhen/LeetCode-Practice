class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } 
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j++) {
                if (isValid(s.substring(i, j))) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
    boolean isValid(String str) {
        Stack<Character> stk = new Stack<>();
        char[] sc = str.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '(') {
                stk.push(sc[i]);
            } else if (!stk.isEmpty() && stk.peek() == '(') {
                stk.pop();
                continue;
            } else {
                return false;
            }
        }
        return stk.isEmpty();
    }
}
