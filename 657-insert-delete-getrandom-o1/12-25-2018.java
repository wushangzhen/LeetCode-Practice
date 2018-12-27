class RandomizedSet {

    /** Initialize your data structure here. */
    private Map<Integer, Integer> hash;
    private List<Integer> nums;
    private Random rand;
    public RandomizedSet() {
        hash = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hash.containsKey(val)) {
            return false;
        }
        hash.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hash.containsKey(val)) {
            return false;
        }
        int index = hash.get(val);
        if (index != nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            hash.put(last, index);
            nums.set(index, last);
        }
        hash.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
