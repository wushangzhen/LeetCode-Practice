class LFUCache {
    Map<Integer, Integer> val;
    Map<Integer, Integer> count;
    Map<Integer, LinkedHashSet<Integer>> map; 
    int cap;
    int min;
    public LFUCache(int capacity) {
        val = new HashMap<>();
        count = new HashMap<>();
        map = new HashMap<>();
        cap = capacity;
        min = 1;
    }
    
    public int get(int key) {
        if (!val.containsKey(key)) {
            return -1;
        }
        int num = count.get(key);
        count.put(key, num + 1);
        map.putIfAbsent(num + 1, new LinkedHashSet<>());
        map.get(num + 1).add(key);
        map.get(num).remove(key);
        if (num == min && map.get(num).size() == 0) {
            min = num + 1;
        }
        return val.get(key);
    }
    
    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (val.containsKey(key)) {
            val.put(key, value);
            get(key);
            return;
        }
        if (val.size() >= cap) {
            LinkedHashSet<Integer> set = map.get(min);
            int evictNum = set.iterator().next();
            map.get(min).remove(evictNum);
            val.remove(evictNum);
            count.put(evictNum, 0);
        }
        val.put(key, value);
        count.put(key, 1);
        map.putIfAbsent(1, new LinkedHashSet());
        map.get(1).add(key);
        min = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
