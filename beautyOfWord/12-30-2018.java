import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class Main {
  /**
   * Iterate through each line of input.
   */
  public static String compute(String input) {
    if (input == null || input.length() == 0) {
      return "";
    }
    String x = input.toLowerCase();
    int[] memo = new int[256];
    for (int i = 0; i < x.length(); i++) {
      if ('a' <= x.charAt(i) && x.charAt(i) <= 'z') {
        memo[x.charAt(i)]++;
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 256; i++) {
      if (memo[i] != 0) {
        list.add(memo[i]);
      }
    }
    Collections.sort(list, (a, b) -> b - a);
    long res = 0;
    int count = 26;
    for (int i : list) {
      res += i * count--;
    }
    return String.valueOf(res);
  } 
  
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      System.out.println(compute(line));
    }
  }
}

