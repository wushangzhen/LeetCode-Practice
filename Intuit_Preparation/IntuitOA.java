package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Peng 2018/10/5
 */
public class IntuitOA {


  public static String find(String[][] pairs) {
//    int[] degree = new int[pairs.length];
    Map<String, Integer> degree = new HashMap<>();
    Map<String, String> map = new HashMap<>();

    for (String[] pair : pairs) {
      map.put(pair[0], pair[1]);
      if (!degree.containsKey(pair[0]))
        degree.put(pair[0], 0);
      degree.put(pair[1], 1);
    }

    String start = "";
    for (Map.Entry<String, Integer> entry : degree.entrySet()) {
      if (entry.getValue() == 0) {
        start = entry.getKey();
      }
    }
    System.out.println(start);

    int cnt = 0;

    while (cnt < (pairs.length)/2) {
      start = map.get(start);
      cnt++;
    }

    return start;
  }


  public static void main(String[] args) {
    String[][] pairs = {{"CW", "P"}, {"P", "B"}, {"B", "Intro"}, {"Intro", "haha"}};
    String[][] pairs2 = {{"CW", "P"}, {"P", "B"}, {"B", "Intro"}};
    System.out.println(find(pairs));
    System.out.println(find(pairs2));
  }
}
