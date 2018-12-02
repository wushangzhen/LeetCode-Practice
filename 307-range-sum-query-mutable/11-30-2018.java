class NumArray {
    int[] prefixSum;
    int[] nums;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1];
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += nums[i - 1];
            prefixSum[i] = sum;
        }
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        int value = nums[i];
        for (int k = i + 1; k < nums.length + 1; k++) {
            prefixSum[k] -= value;
            prefixSum[k] += val;
        }
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
