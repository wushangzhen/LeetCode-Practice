public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 0);
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            if (map.containsKey(sum)) {
                res.add(map.get(sum));
                res.add(i - 1);
                break;
            }
            map.put(sum, i);
        }
        return res;
    }
}
