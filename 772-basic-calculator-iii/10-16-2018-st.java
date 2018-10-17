class Solution {
    public int calculate(String s) {
        int res = 0;
        int curRes = 0;
        int num = 0;
        char sign = '+';
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (Character.isDigit(sc[i])) {
                num = num * 10 + sc[i] - '0';
            }
            if (sc[i] == '(') {
                int j = i;
                int cnt = 0;
                for (; i < sc.length; i++) {
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
            if (sc[i] == '+' || sc[i] == '-' || sc[i] == '*' || sc[i] == '/' || i == sc.length - 1) {
                switch (sign) {
                    case '+': 
                        curRes += num;
                        break;
                    case '-': 
                        curRes -= num;
                        break;
                    case '*': 
                        curRes *= num;
                        break;
                    case '/': 
                        curRes /= num;
                        break;
                }
                if (sc[i] == '+' || sc[i] == '-' || i == sc.length - 1) {
                    res += curRes; 
                    curRes = 0;
                }
                sign = sc[i];
                num = 0;
            }  
        }
        return res;
        
    }
}
