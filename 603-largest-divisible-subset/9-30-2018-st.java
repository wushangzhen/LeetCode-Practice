public class Solution {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int n = nums.length;
        int[] f = new int[n]; 
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                    pre[i] = j;
                }
            }
        }
        int max = 0;
        int max_i = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                max = f[i];
                max_i = i;
            }
        }
        result.add(nums[max_i]);
        while (max_i != pre[max_i]) {
            max_i = pre[max_i];
            result.add(nums[max_i]);
        }
        Collections.reverse(result);
        return result;
    }
}
