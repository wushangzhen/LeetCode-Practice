import java.util.TreeMap;
class SummaryRanges {
    /** Initialize your data structure here. */
    TreeMap<Integer, int[]> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Integer l = map.floorKey(val);
        Integer r = map.ceilingKey(val);
        if (l != null && r != null && map.get(l)[1] + 1 == val && val + 1 == map.get(r)[0]) {
            map.get(l)[1] = map.get(r)[1];
            map.remove(r);
        } else if (l != null && map.get(l)[1] + 1 >= val) {
            map.get(l)[1] = Math.max(map.get(l)[1], val);
        } else if (r != null && map.get(r)[0] - 1 <= val) {
            map.get(r)[0] = Math.min(map.get(r)[0], val);
        } else {
            map.put(val, new int[]{val, val});
        }
        return;
    }
    
    public int[][] getIntervals() {
        int n = map.size();
        List<int[]> list = new ArrayList<>(map.values());
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
