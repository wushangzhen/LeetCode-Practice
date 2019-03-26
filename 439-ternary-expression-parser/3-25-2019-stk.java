class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        Stack<Character> stk = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stk.isEmpty() && stk.peek() == '?') {
                stk.pop();
                char first = stk.pop();
                stk.pop();
                char second = stk.pop();
                if (c == 'T') {
                    stk.push(first);
                } else {
                    stk.push(second);
                }
            } else {
                stk.push(c);
            }
        }
        return String.valueOf(stk.peek());
    }
}
