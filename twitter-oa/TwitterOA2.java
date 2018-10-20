package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Peng 2018/10/17
 */
public class TwitterOA2 {

    /*
     * Complete the 'textQueries' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY sentences
     *  2. STRING_ARRAY queries
     */

  public static void textQueries(List<String> sentences, List<String> queries) {
    // Write your code here
    List<Map<String, Integer>> list = new ArrayList<>();

    for (int i = 0; i < sentences.size(); i++) {
      Map<String, Integer> map = new HashMap<>();
      String sentence = sentences.get(i);
      String[] words = sentence.split(" ");
      for (String word : words) {
        map.put(word, map.getOrDefault(word, 0) + 1);
      }
      list.add(map);
    }

    for (int i = 0; i < queries.size(); i++) {
      String str = queries.get(i);
      String[] ss = str.split(" ");
      boolean flag = false;
      for (int j = 0; j < list.size(); j++) {
        Map<String, Integer> map = list.get(j);
        int cnt = Integer.MAX_VALUE;
        for (String s : ss) {
          if (map.containsKey(s)) {
            cnt = Math.min(cnt, map.get(s));
          } else {
            cnt = 0;
            break;
          }
        }
        if (cnt == 0) {}
        else {
          for (int k = 0; k < cnt; k++) {
            System.out.print(j + " ");
          }
          flag = true;
          // print j;
        }
      }
      if (!flag) System.out.println(-1);
      else System.out.println("");
    }


  }

}


