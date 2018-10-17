public class Solution {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        Stack<Integer> stk = new Stack<>();
        char[] sc = s.toCharArray();
        int num = 0;
        int res = 0;
        int sign = 1;
        for (char c : sc) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stk.push(res);
                stk.push(sign);
                num = 0;
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                int tempSign = stk.pop();
                int tempResult = stk.pop();
                res = tempResult + tempSign * res;
                num = 0;
                sign = 1;
            }
        }
        res += sign * num;
        return res;
    }
}
