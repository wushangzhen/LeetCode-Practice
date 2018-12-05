class NumArray {
    int[] nums;
    int[] C;
    int n;
    public int lowbit(int x) {
        return x & -x;
    }
    public void add(int index, int val) {
        for (int i = index + 1; i <= n; i += lowbit(i)) {
            C[i] += val;
        }
    }
    public int getSum(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= lowbit(i)) {
            sum += C[i];
        }
        return sum;
    }
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        C = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i, nums[i]);
        } 
    }
    
    public void update(int i, int val) {
        add(i, val - nums[i]);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
