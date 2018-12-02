class NumArray {
    private int[] nums;
    private int[] C;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        C = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i, nums[i]);
        }
    }
    void add(int x, int val) {
        x++;
        for (int i = x; i <= n; i += lowbit(i)) {
            C[i] += val;
        }
    }
    int lowbit(int x) {
        return x & -x;
    }
    
    public void update(int i, int val) {
        add(i, val - nums[i]);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }
    
    public int sum(int x) {
        x++;
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += C[i];
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
