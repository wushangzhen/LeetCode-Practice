public class Solution {
    /**
     * @param s: the expression string
     * @return: the answer
     */
    public int calculate(String s) {
        // Write your code here
        Stack<Integer> stk = new Stack<>();
        char[] sc = s.toCharArray();
        int n = sc.length;
        int num = 0;
        char sign = '+';
        int curSum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(sc[i])) {
                num = num * 10 + sc[i] - '0';
            } else if (sc[i] == '(') {
                int j = i;
                int count = 0;
                for (; i < n; i++) {
                    if (sc[i] == '(') {
                        count++;
                    } 
                    if (sc[i] == ')') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                num = calculate(s.substring(j + 1, i));
            }
            if (!Character.isDigit(sc[i]) && sc[i] != ' ' || i == n - 1) {
                switch(sign) {
                    case '+':
                        curSum += num;
                        break;
                    case '-':
                        curSum -= num;
                        break;
                    case '*':
                        curSum *= num;
                        break;
                    case '/':
                        curSum /= num;
                        break;
                }
                if (sc[i] == '+' || sc[i] == '-' || i == n - 1) {
                    res += curSum;
                    curSum = 0;
                }
                sign = sc[i];
                num = 0;
            }
        }
        return res;
    }
}
