import java.util.NavigableMap;
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        NavigableMap<Integer, Integer> intervalsMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalsMap.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = intervalsMap.ceilingEntry(intervals[i][1]);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        return result;
    }
}
