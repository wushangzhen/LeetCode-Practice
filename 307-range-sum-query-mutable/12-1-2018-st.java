class NumArray {
    int[] C, A;
    int n;
    public int lowBit(int x) {
        return x & -x;
    }

    public NumArray(int[] nums) {
        n = nums.length;
        this.C = new int[n + 1];
        this.A = nums;
        for (int i = 0; i < n; i++) {
            add(i, A[i]);
        }
    }
    
    public void update(int i, int val) {
        add(i, val - A[i]);
        A[i] = val;
    }
    
    public void add(int x, int val) {
        x++;
        for (int i = x; i <= n; i += lowBit(i)) {
            C[i] += val;
        }
    }
    public int sum(int x) {
        x++;
        int res = 0;
        for (int i = x; i > 0; i -= lowBit(i)) {
            res += C[i];
        }
        return res;
    }
    
    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
