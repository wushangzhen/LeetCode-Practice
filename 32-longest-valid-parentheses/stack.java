class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] sc = s.toCharArray();
        int n = sc.length;
        int start = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (sc[i] == '(') {
                stk.push(i);
            } else {
                if (stk.isEmpty()) {
                    start = i + 1;
                } else {
                    stk.pop();
                    res = stk.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stk.peek());
                }
            }
        }
        return res;
        
    }
}
