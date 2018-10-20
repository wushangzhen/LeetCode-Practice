class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char[] sc = s.toCharArray();
        int n = sc.length;
        for (int i = 0; i < n; i++) {
            if (sc[i] == '(' || sc[i] == '{' || sc[i] == '[') {
                stk.push(sc[i]);
            } else {
                if (stk.isEmpty()) {
                    return false;
                }
                char temp = stk.pop();
                if ((temp == '(' && sc[i] == ')') || (temp == '{' && sc[i] == '}') || (temp == '[' && sc[i] == ']')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
