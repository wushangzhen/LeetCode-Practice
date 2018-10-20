import java.io.*;
import java.util.*;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

// We want to allow students to use variables when entering expressions in the calculator. In addition to the formula string, we’ll add a new input to our function that holds variables and their values: 
//     {"e": 8, "y": 7, "pressure": 5}
// and our string inputs now have a format like 
//       "(e+3)-(pressure+temperature)+2".
    
// Evaluate the formula result as fully as possible using the input variables. It is possible that not all variables have known values, in which case you should preserve them in the output.

// Sample input:
//     variables = {"e": 8, "y": 7, "pressure": 5}
//     expression = "(e+3)-(pressure+temperature)+2"

// Sample output:
//     "8-temperature"

class Solution {
  public static String calculate(String str, Map<String, Integer> map) {
    if (str == null || str.length() == 0) {
      return "";
    }
    String pure = deleteParentheses(str);
    //Stack<Integer> stk = new Stack<>();
    char[] sc = pure.toCharArray();
    int num = 0;
    int res = 0;
    char sign = '+';
    String strPart = "";
    for (int i = 0; i < sc.length; i++) {
      if (Character.isDigit(sc[i])) {
        num = num * 10 + sc[i] - '0';
      }
      if (!Character.isDigit(sc[i]) && sc[i] != '+' && sc[i] != '-') {
        int j = i;
        String strTemp = "";
        while (i < sc.length && sc[i] >= 'a' && sc[i] <= 'z') {
          strTemp += sc[i];
          i++;
        }
        if (map.containsKey(strTemp)) {
          num = map.get(strTemp);
        } else {
            strPart += sign + strTemp;
        }
      }
      if (i < sc.length && (sc[i] == '+' || sc[i] == '-' || i == sc.length - 1)) {
        if (sign == '+') {
          res += num;
        }
        if (sign == '-') {
          res -= num;
        }
        if (i == sc.length - 1) {
          
        }
        num = 0;
        sign = sc[i];
      }
    }
    res += num;
    if (res == 0) {
      return strPart.substring(1);
    }
    return res + strPart;
  }
  public static String deleteParentheses(String str) {
    char[] scc = str.toCharArray();
    Stack<Integer> stk = new Stack<>();
    for (int i = 0; i < scc.length; i++) {
      if (scc[i] == '(') {
        stk.push(i);
      } else if (scc[i] == ')') {
        int index = stk.pop();
        if (index != 0 && scc[index - 1] == '-') {
          changeSymbol(scc, index + 1, i);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < scc.length; i++) {
      if (scc[i] != '(' && scc[i] != ')') {
        sb.append(scc[i]);
      }
    }
    return sb.toString();
  }
  public static void changeSymbol(char[] scc, int left, int right) {
    for (int i = left; i < right; i++) {
      if (scc[i] == '+') {
        scc[i] = '-';
      } else if (scc[i] == '-') {
        scc[i] = '+';
      }
    }
  }
  
  public static void main(String[] args) {    
    String expression = "0+a";
    Map<String, Integer> variables = ImmutableMap.of(
      "e", 8,
      "y", 7,
      "pressure", 5);

    System.out.println(calculate(expression, variables));
  }
}


