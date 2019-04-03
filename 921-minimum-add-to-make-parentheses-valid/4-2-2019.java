class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stk = new Stack<>();
        char[] sc = S.toCharArray();
        for (char c : sc) {
            if (c == '(') {
            } else if (!stk.isEmpty() && stk.peek() == '(') {
                stk.pop();
                continue;
            }
            stk.push(c);
        }
        return stk.size();
    }
}
