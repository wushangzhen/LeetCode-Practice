import java.util.*;
import java.lang.StringBuilder;
public class Calculator2 {
    private static char[] sc;
    public static String compute(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String pure = deleteParentheses(str);
        return pure;
    }

    public static String deleteParentheses(String str) {
        sc = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != ' ') {
                sb.append(sc[i]);
            }
        }
        str = sb.toString(); 
        sc = str.toCharArray();
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '(') {
                stk.push(i);
            } else if (sc[i] == ')') {
                int index = stk.pop();
                int symbol = index;
                if (index != 0 && sc[index - 1] == '-') {
                    changeSymbol(index + 1, i);
                }
            }
        
        }
        sb.setLength(0);
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != ' ' && sc[i] != '(' && sc[i] != ')') {
                sb.append(sc[i]);
            }
        }
        return sb.toString();
    }
    public static void changeSymbol(int left, int right) {
        for (int i = left; i < right; i++) {
            if (sc[i] == '+') {
                sc[i] = '-';
            } else if (sc[i] == '-') {
                sc[i] = '+';
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(Calculator2.compute("1 - (2 - 3 - (2 + 3))"));
    }

}
