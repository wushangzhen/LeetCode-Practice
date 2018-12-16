class TwoSum {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.putIfAbsent(number, 0);
        map.put(number, map.get(number) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer key : map.keySet()) {
            map.put(key, map.get(key) - 1);
            if (map.containsKey(value - key) && map.get(value - key) > 0) {
                map.put(key, map.get(key) + 1);
                return true;
            }
            map.put(key, map.get(key) + 1);
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
