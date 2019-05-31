class MyHashSet {

    /** Initialize your data structure here. */
    boolean[] map;
    public MyHashSet() {
        map = new boolean[100];
    }
    
    public void add(int key) {
        if (key >= map.length) {
            extend(key);
        }
        map[key] = true;
    }
    
    public void remove(int key) {
        if (key < map.length) {
            map[key] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return key < map.length && map[key];
    }
    void extend(int key) {
        map = Arrays.copyOf(map, key + 1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
