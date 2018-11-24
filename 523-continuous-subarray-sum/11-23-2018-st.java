class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int t = (k == 0) ? sum : sum % k;
            if (memo.containsKey(t)) {
                if (i - memo.get(t) > 1) {
                    return true;
                }
            } else {
                memo.put(t, i); // this is necessary because we have to make sure it's value should be farest part
            }
        }
        return false;
    }
}
