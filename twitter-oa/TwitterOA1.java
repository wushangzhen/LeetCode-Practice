package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Peng 2018/10/17
 */
class TwitterOA1 {

    /*
     * Complete the 'closest' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

  public static List<Integer> closest(String s, List<Integer> queries) {
    // Write your code here
    Map<Character, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!map.containsKey(ch)) {
        map.computeIfAbsent(ch, a -> new ArrayList<>()).add(i);
      } else {
        map.get(ch).add(i);
      }
    }

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < queries.size(); i++) {
      char ch = s.charAt(queries.get(i));
      if (map.containsKey(ch) && map.get(ch).size() == 1) {
        res.add(-1);
      } else {
        List<Integer> list = map.get(ch);
        res.add(binarySearch(list, queries.get(i)));
      }
    }
    return res;
  }

  static int binarySearch(List<Integer> list, int target) {
    int left = 0;
    int right = list.size();
    while (left <= right) {
      int mid = left + (right - left)/2;
      if (list.get(mid) == target) {
        return helper(list, mid);
      } else if (list.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  static int helper(List<Integer> list, int i) {
    int target = list.get(i);
    if (i - 1 < 0) return list.get(i+1);
    if (i + 1 >= list.size()) return list.get(i-1);

    if (Math.abs(target - list.get(i-1)) > Math.abs(target - list.get(i + 1))) {
      return list.get(i+1);
    } else {
      return list.get(i-1);
    }
  }

}


