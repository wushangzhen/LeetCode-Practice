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
        int num = 0;
        char sign = '+';
        int res = 0;
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(sc[i])) {
                num = num * 10 + sc[i] - '0';
            }
            if (!Character.isDigit(sc[i]) && sc[i] != ' ' || i == n - 1) {
                switch (sign) {
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
                num = 0;
                sign = sc[i];
            }
        }
        return res;
    }
}
