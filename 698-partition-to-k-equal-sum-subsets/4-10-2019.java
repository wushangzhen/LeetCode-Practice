class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        int n = nums.length;
        boolean[] visited = new boolean[n];
        return helper(0, 0, 0, k, nums, target, visited);
    }
    
    boolean helper(int start, int curSum, int curNum, int k, int[] nums, int target, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (curSum == target && curNum > 0) {
            return helper(0, 0, 0, k - 1, nums, target, visited);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (helper(i + 1, curSum + nums[i], curNum + 1, k, nums, target, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
    
}
