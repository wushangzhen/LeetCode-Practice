public class Solution {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        Stack<Integer> stk = new Stack<>();
        char[] sc = s.toCharArray();
        int n = sc.length;
        char sign = '+';
        int num = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(sc[i])) {
                num = num * 10 + sc[i] - '0';
            } else if (sc[i] == '(') {
                int j = i;
                int cnt = 0;
                for (; i < n; i++) {
                    if (sc[i] == '(') {
                        cnt++;
                    }
                    if (sc[i] == ')') {
                        cnt--;
                    }
                    if (cnt == 0) {
                        break;
                    }
                }
                num = calculate(s.substring(j + 1, i));
            } 
            if (sc[i] == '+' || sc[i] == '-' || i == n - 1) {
                switch (sign) {
                    case '+': 
                        stk.push(num);
                        break;
                    case '-': 
                        stk.push(-num);
                        break;
                }
                sign = sc[i];
                num = 0;
            }
        }
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }
}
