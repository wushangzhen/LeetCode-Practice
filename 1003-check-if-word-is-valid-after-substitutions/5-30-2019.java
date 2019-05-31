class Solution {
    public boolean isValid(String S) {
        Stack<Character> stk = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == 'c') {
                if (stk.isEmpty() || stk.pop() != 'b') {
                    return false;
                }
                if (stk.isEmpty() || stk.pop() != 'a') {
                    return false;
                }
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}
