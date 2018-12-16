class TwoSum {
    Set<Integer> num;
    Set<Integer> sum;
    /** Initialize your data structure here. */
    public TwoSum() {
        num = new HashSet<>();
        sum = new HashSet<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (num.contains(number)) {
            sum.add(number * 2);
        } else {
            Iterator<Integer> it = num.iterator();
            while (it.hasNext()) {
                sum.add(it.next() + number);
            }
            num.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sum.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
