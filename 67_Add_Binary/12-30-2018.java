import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static String addBinary(String input) {
    if (input == null || input.length() == 0) {
      return "";
    }
    
    String[] strs = input.split(",");
    String a = strs[0];
    String b = strs[1];
    String res = "";
    int p1 = a.length() - 1;
    int p2 = b.length() - 1;
    int carry = 0;
    
    while (p1 >= 0 && p2 >= 0) {
      int x = a.charAt(p1) - '0';
      int y = b.charAt(p2) - '0';
      int sum = x + y + carry;
      carry = sum / 2;
      res = sum % 2 + res;
      p1--;
      p2--;
    }
    while (p1 >= 0) {
      int x = a.charAt(p1) - '0';
      int sum = x + carry;
      carry = sum / 2;
      if (sum == 0 && carry == 0) {
        break;
      }
      res = sum % 2 + res;
      p1--;
    }
    while (p2 >= 0) {
      int x = b.charAt(p2) - '0';
      int sum = x + carry;
      carry = sum / 2;
      if (sum == 0 && carry == 0) {
        break;
      }
      res = sum % 2 + res;
      p2--;
    }
    if (carry == 1) {
      res = carry + res;
    }
    return res;
  }
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      System.out.println(addBinary(line));
    }
  }
}

