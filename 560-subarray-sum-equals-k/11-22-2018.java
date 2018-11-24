class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1); 
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (memo.containsKey(sum - k)) {
                count += memo.get(sum - k);
            }
            memo.put(sum, memo.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
