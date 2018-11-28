import java.util.*;
class Test {
//         ")(()(" -> "()(()())"
        // )((
        // 
    public static String valid(String s) {
        Stack<Character> stk = new Stack<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            if (c == ')' && stk.size() > 0 && stk.peek() == '(') {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        String res = s;
        while (!stk.isEmpty()) {
            char c = stk.pop();
            if (c == ')') {
                res = '(' + res;
            } else {
                res = res + ')';
            }
        }
        return res;
        
        
    }
    public static void main(String[] args) {
        String s = "(((";
        System.out.println(Test.valid(s));
    }
}
