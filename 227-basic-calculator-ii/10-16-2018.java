class Solution {
    public int calculate(String s) {
        char sign = '+';
        int num = 0;
        Stack<Integer> stk = new Stack<>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (Character.isDigit(sc[i])) {
                num = num * 10 + (sc[i] - '0');
            }
            if ((!Character.isDigit(sc[i]) && sc[i] != ' ' ) || i == sc.length - 1){
                if (sign == '+') {
                    stk.push(num);
                }
                if (sign == '-') {
                    stk.push(-num);
                }
                if (sign == '*') {
                    stk.push(stk.pop() * num);
                }
                if (sign == '/') {
                    stk.push(stk.pop() / num);
                }
                num = 0;
                sign = sc[i];
            }
        }
        int result = 0;
        while (!stk.isEmpty()) {
            result += stk.pop();
        }
        return result;
    }
}
