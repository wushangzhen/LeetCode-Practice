class RandomizedCollection {

    /** Initialize your data structure here. */
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand;
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new LinkedHashSet<>());
        } 
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val).iterator().next();
        map.get(val).remove(index); // has to be here
        if (index < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.get(last).remove(list.size() - 1);
            map.get(last).add(index);
        }
        list.remove(list.size() - 1);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size())); 
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
