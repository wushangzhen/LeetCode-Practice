class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] sc = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '(' || sc[i] == '[' || sc[i] == '{') {
                stk.push(sc[i]);
            } else {
                if (sc[i] == '}') {
                    if (!stk.isEmpty() && stk.peek() == '{') {
                        stk.pop();
                        continue;
                    }
                } else if (sc[i] == ']') {
                    if (!stk.isEmpty() && stk.peek() == '[') {
                        stk.pop();
                        continue;
                    }
                } else if (sc[i] == ')') {
                    if (!stk.isEmpty() && stk.peek() == '(') {
                        stk.pop();
                        continue;
                    }
                }
                return false;
            }
        }
        return stk.isEmpty();
    }
}
