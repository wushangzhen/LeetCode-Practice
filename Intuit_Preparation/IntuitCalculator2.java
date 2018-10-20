package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Peng 2018/10/17
 */
public class IntuitCalculator2 {

  public String calculator(String str, Map<Character, Integer> dist) {
    String pure = deleteParenthese(str);
    int num = 0;
    int res = 0;
    char op = '+';
    String strPart = "";
    for (int i = 0; i < pure.length(); i++) {
      char ch = pure.charAt(i);
      if (Character.isDigit(ch)) {
        num = num* 10 + (ch - '0');
      }
      if (!Character.isDigit(ch) && ch != '+' && ch != '-') {
        if (dist.containsKey(ch)) {
          num = dist.get(ch);
        } else {
          strPart = strPart + op + ch;
          num = 0;
          continue;
        }
      }
      if (ch == '+' || ch == '-' || i == pure.length()-1) {
        if (op == '+') {
            res += num;
            num = 0;
        }
        if (op == '-') {
            res -= num;
            num = 0;
        }
        op = ch;
      }

    }

    return res + strPart;

  }

  public String deleteParenthese(String str) {
    Stack<Integer> stack = new Stack<>();
    char[] arr = str.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      char ch = arr[i];
      if (ch == '(') {
        stack.push(i);
      }
      if (ch == ')') {
        int index = stack.peek();
        if (index != 0 && arr[index-1] == '-') {
          //arr[index - 1] = '+';
          //TODO change(arr, stack.pop(), i);
          change(arr, stack.pop(), i);
        } else {
          stack.pop();
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != '(' && arr[i] != ')' && arr[i] != ' ') {
        sb.append(arr[i]);
      }
    }
    return sb.toString();
  }


  public void change(char[] arr, int left, int right) {
    for (int i = left + 1; i < right; i++) {
      if (arr[i] == '+') {
        arr[i] = '-';
      } else if (arr[i] == '-') {
        arr[i] = '+';
      }
    }
    return;
  }


  public static void main(String[] args) {
    // ( a - ( b + (c - 5)))
    IntuitCalculator2 intuitCalculator2 = new IntuitCalculator2();
    String test = "a-(b+(c-5))"; //9-b
    String test2 = "( 5 - ( b + 6 + (c - 5))) + 10";

    HashMap<Character, Integer> map = new HashMap<>();
    map.put('a', 5);
    map.put('c', 1);
    System.out.println(intuitCalculator2.deleteParenthese(test));

    System.out.println(intuitCalculator2.calculator(test, map));
    System.out.println(intuitCalculator2.calculator(test2, map));
  }

}
