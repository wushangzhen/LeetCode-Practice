import java.io.*;
import java.util.*;

public class Solution {
  // If you need extra classes, you can define them privately here within class Solution

  // Prints to standard output.
  static String findMidpointCourse(String[][] pairs) {
    // Your code here.
    String result = "";
    if (pairs == null || pairs.length == 0) {
      return result;
    }
    int n = pairs.length;
    int m = pairs[0].length;
    if (m == 0) {
      return result;
    }
    int number = n;
    Map<String, Integer> degree = new HashMap<>();
    Map<String, String> map = new HashMap<>();
    for (String[] pair : pairs) {
      map.put(pair[0], pair[1]);
      if (!degree.containsKey(pair[0])) {
        degree.put(pair[0], 0);
      }
      degree.put(pair[1], 1);
    }
    String start = "";
    for (Map.Entry<String, Integer> entry : degree.entrySet()) {
      if (entry.getValue() == 0) {
        start = entry.getKey();
        break;
      }
    }
    int cnt = 0;
    while (cnt < number / 2) {
      start = map.get(start);
      cnt++;
    }
    return start;
  }

  // DO NOT MODIFY MAIN()
  public static void main(String[] args) {
    List<String[]> arg1 = new ArrayList<String[]>();

    String line;
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      while ((line = br.readLine()) != null) {
        if (line.equals("")) {
          continue;
        }

        arg1.add(line.split(" "));
      }
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    String[][] pairs = arg1.toArray(new String[arg1.size()][]);

    System.out.println(findMidpointCourse(pairs));
  }
}

