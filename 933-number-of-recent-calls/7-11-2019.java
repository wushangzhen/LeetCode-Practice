class RecentCounter {
    TreeSet<Integer> set;
    public RecentCounter() {
        set = new TreeSet<>();
    }
    
    public int ping(int t) {
        set.add(t);
        return set.tailSet(t - 3000).size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
