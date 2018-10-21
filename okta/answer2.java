// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String[] solution(String[] A, int Y) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return new String[0];
        }
        Map<Integer, Map<String, Integer>> mToString = new TreeMap<>(); // Record the minute and another map to record people and request times
        int maxMin = 0; // record the max minutes
        for (String str : A) {
            String[] spStr = str.split(" ");
            int min = Integer.parseInt(spStr[1]) / 60; // get the minute
            if (maxMin < min) {
                maxMin = min;
            }
            mToString.putIfAbsent(min, new HashMap<>());
            mToString.get(min).putIfAbsent(spStr[0], 0);
            int temp = mToString.get(min).get(spStr[0]);
            if (temp < Y) { // deal with the overflow
                mToString.get(min).put(spStr[0], temp + 1);
            }
        }
        
         
        for (int i = 0; i <= maxMin; i++) {
            mToString.putIfAbsent(i, new HashMap<>());
        }
        // we have recorded the request without overflow
        Map<String, Integer> totalSum = new TreeMap<>(); // record the total sum of all users in last minutes
        for (Map.Entry<Integer, Map<String, Integer>> entry : mToString.entrySet()) {
            Map<String, Integer> mapTemp = entry.getValue();
            for (Map.Entry<String, Integer> entryTemp : mapTemp.entrySet()) {
                Map<String, Integer> prevMap = mToString.get(entry.getKey() - 1); // get the last minute's data
                int prevValue = 0;
                if (prevMap != null) {
                    prevValue = prevMap.getOrDefault(entryTemp.getKey(), 0);
                }
                totalSum.putIfAbsent(entryTemp.getKey(), 0);
                totalSum.put(entryTemp.getKey(), totalSum.get(entryTemp.getKey()) + entryTemp.getValue());
                mapTemp.put(entryTemp.getKey(), prevValue + mapTemp.get(entryTemp.getKey()));
                Map<String, Integer> prevMap5 = mToString.get(entry.getKey() - 5); // get the data of five minutes ago
                int prevValue5 = 0;
                if (prevMap5 != null) {
                    prevValue5 = prevMap5.getOrDefault(entryTemp.getKey(), 0);
                }
                mapTemp.put(entryTemp.getKey(), mapTemp.get(entryTemp.getKey()) - prevValue5);
            }
            int max = 0;
            int count = 0;
            String blackName = "";
            for (Map.Entry<String, Integer> entryTemp : mapTemp.entrySet()) {
                count += entryTemp.getValue();
                if (entryTemp.getValue() > max) {
                    max = entryTemp.getValue();
                    blackName = entryTemp.getKey();
                }
            }
            // record the black name and max name
            if (count >= 10 && max > count / 2) { // remove next two minutes black name's request
                int key = entry.getKey();
                key++;
                if (key < mToString.size()) {
                    mToString.get(key).remove(blackName);
                }
                key++;
                if (key < mToString.size()) {
                    mToString.get(key).remove(blackName);
                }
            }
        }
        // print output
        int size = totalSum.size();
        String[] result = new String[size];
        int i = 0;
        for (Map.Entry<String, Integer> entry : totalSum.entrySet()) {
            result[i] = entry.getKey() + " " + entry.getValue();
            i++;
        }
        return result;
    }
}
