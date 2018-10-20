import java.util.*;
public class Calculator {
    public static String compute(String str, Map<String, Integer> map) {
        Stack<String> stk = new Stack<>();
        String result = "";
        if (str == null || str.length() == 0) {
            return result;
        }
        String[] keys = map.keySet();
        for (String key : keys) {
            str = str.replaceAll(key, String.valueOf(map.get(key));
        }
        char[] sc = str.toCharArray();
        int num = 0;
        String numStr = "";
        char sign = '+'; // represents "+"
        for (int i = 0; i < sc.length; i++) {
            if (Character.isDigit(sc[i])) {
                num = num * 10 + sc[i] - '0';
                numStr = String.valueOf(num);
            }
            if (sc[i] == '(') {
                int count = 0;
                int j = i;
                for (; i < sc.length; i++) {
                    if (sc[i] == '(') {
                        count++;
                    } else if (sc[i] == ')') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                numStr = compute(str.substring(j + 1, i));
            }
            if (sc[i] == '+' || sc[i] == '-' || i == sc.length - 1) {
                if (sign == '+') {
                    stk.push(numStr);
                } else {
                    stk.push("-" + numStr);
                }
                num = 0;
                numStr = "";
                sign = sc[i];
            }
        }
        int res = 0;
        while (!stk.isEmpty()) {
            String s = stk.pop();
            if (s.startsWith("-")) {
                res -= Integer.parseInt(s.substring(1));
                continue;
            }
            res += Integer.parseInt(s);
        }
        result = String.valueOf(res);
        return result;
    }
    public static void main(String[] args) {
        String str = "1 - (2 - (3 - 1))";
        System.out.println(Calculator.compute(str));
    }
}
