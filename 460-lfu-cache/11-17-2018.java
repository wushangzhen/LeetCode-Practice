class LFUCache {
    Map<Integer, LinkedHashSet<Integer>> hash;
    int cap;
    int bottom;
    int top;
    int size;
    Map<Integer, Integer> val;
    Map<Integer, Integer> count;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        bottom = 1;
        top = 1;
        hash = new HashMap<>();
        val = new HashMap<>();
        count = new HashMap<>();
    }
    
    public int get(int key) {
        if (!val.containsKey(key)) {
            return -1;
        }
        hash.get(count.get(key)).remove(key);
        if (!hash.containsKey(count.get(key) + 1)) {
            hash.put(count.get(key) + 1, new LinkedHashSet());
            top++;
        }
        hash.get(count.get(key) + 1).add(key);
        if (count.get(key) == bottom && hash.get(count.get(key)).size() == 0) {
            bottom++;
        }
        count.put(key, count.get(key) + 1);
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
        } else if (size >= cap) {
            LinkedHashSet<Integer> bottomSet = hash.get(bottom);
            int delkey = bottomSet.iterator().next();
            hash.get(bottom).remove(delkey);
            val.remove(delkey);
            count.remove(delkey);
            size--;
        }
        if (!hash.containsKey(1)) {
            hash.put(1, new LinkedHashSet());
        }
        hash.get(1).add(key);
        val.put(key, value);
        count.put(key, 1);
        bottom = 1;
        size++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
