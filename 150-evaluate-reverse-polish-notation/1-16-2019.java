class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int n = tokens.length;
        int i = 0;
        while (i < n) {
            if (tokens[i].equals("+")) {
                int a = stk.pop();
                int b = stk.pop();
                a = b + a;
                stk.push(a);
            } else if (tokens[i].equals("-")) {
                int a = stk.pop();
                int b = stk.pop();
                a = b - a;
                stk.push(a);
            } else if (tokens[i].equals("*")) {
                int a = stk.pop();
                int b = stk.pop();
                a = b * a;
                stk.push(a);
            } else if (tokens[i].equals("/")) {
                int a = stk.pop();
                int b = stk.pop();
                a = b / a;
                stk.push(a);
            } else {
                stk.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stk.peek();
    }
}
