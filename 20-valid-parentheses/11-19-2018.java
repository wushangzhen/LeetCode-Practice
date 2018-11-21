class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stk = new Stack<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else if (!stk.isEmpty()) {
                if (c == ')') {
                    if (stk.pop() != '(') {
                        return false;
                    }
                }
                if (c == '}') {
                    if (stk.pop() != '{') {
                        return false;
                    }
                }
                if (c == ']') {
                    if (stk.pop() != '[') {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return stk.isEmpty();
    }
}
