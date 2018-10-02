public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
max_sum 必然是以A[i](取值范围为A[0] ~ A[n-1])结尾的某段构成的，也就是说max_sum的candidate必然是以A[i]结果的。如果遍历每个candidate，然后进行比较，那么就能找到最大的max_sum了。

假设把A[i]之前的连续段叫做sum。可以很容易想到:

如果sum>=0，就可以和A[i]拼接在一起构成新的sum’。因为不管A[i]多大，加上一个正数总会更大，这样形成一个新的candidate。

反之，如果sum<0，就没必要和A[I]拼接在一起了。因为不管A[i]多小，加上一个负数总会更小。此时由于题目要求数组连续，所以没法保留原sum，所以只能让sum等于从A[i]开始的新的一段数了，这一段数字形成新的candidate。

如果每次得到新的candidate都和全局的max_sum进行比较，那么必然能找到最大的max sum subarray. 
在循环过程中，用max_sum记录历史最大的值。从A[0]到A[n-1]一步一步地进行。
