import java.util.*;
class Solution {
    public String followUp(String s, Map<Character, Integer> map) {

        Stack<String> stk = new Stack<>();
        char[] sc = s.toCharArray();
        int n = sc.length;
        int num = 0;
        String res = "";
        char sign = '+';
        String numStr = "";
        for (int i = 0; i < n; i++) {
            if (sc[i] >= 'a' || sc[i] <= 'z') { 
                if (map.containsKey(sc[i])) {
                    num = map.get(sc[i]);
                    sc[i] = (char)('0' + num);
                }
            }
        }
        s = String.valueOf(sc);
        num = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(sc[i])) {
                num = num * 10 + sc[i] - '0';
                numStr = String.valueOf(num);
            }
            if (sc[i] >= 'a' && sc[i] <= 'z') {
                numStr = String.valueOf(sc[i]);
            } 
            if (sc[i] == '(') {
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
                numStr = followUp(s.substring(j + 1, i), map);
            }
            if (!Character.isDigit(sc[i]) && sc[i] != ' ' || i == n - 1) {
                switch(sign) {
                    case '+':
                        StringBuilder sb = new StringBuilder();
                        sb.append("+");
                        sb.append(numStr);
                        stk.push(sb.toString());
                        break;
                    case '-':
                        numStr = "+" + numStr;
                        int m = numStr.length();
                        char[] nc = numStr.toCharArray();
                        for (int j = 0; j < m; j++) {
                            if (nc[j] == '+') {
                                nc[j] = '-';
                            } else if (nc[j] == '-') {
                                nc[j] = '+';
                            }
                        }
                        stk.push(String.valueOf(nc));
                        break;
                }
                sign = sc[i];
                numStr = "";
                num = 0;
            }
        }

        int sum = 0;
        String alpha = "";
        while(!stk.isEmpty()) {
            String str = stk.pop();
            char[] tc = str.toCharArray();
            for (int i = 0; i < tc.length;) {
                if (tc[i] == '+' || tc[i] == '-') {
                    sign = tc[i];
                    int number = 0;
                    i = i + 1;
                    if (i < tc.length && tc[i] >= 'a' && tc[i] <= 'z') {
                        alpha += sign;
                        alpha += String.valueOf(tc[i]);
                        i++;
                        continue;
                    }
                    while (i < tc.length && tc[i] != '+' && tc[i] != '-') {
                        number = number * 10 + tc[i] - '0'; 
                        i++; 
                    }
                    if (sign == '+') {
                        sum += number;
                    }
                    if (sign == '-') {
                        sum -= number;
                    }
                }
            } 
        }
        return String.valueOf(sum) + alpha;
    }
}
public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 5);
        map.put('c', 1);
        System.out.println(solution.followUp("a - (b + (c - 5))", map)); 
    }
}
