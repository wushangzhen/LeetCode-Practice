class Pair {
    int index; // real index + 1
    int sum;
    public Pair(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }
}
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        Pair[] pairs = new Pair[n + 1];
        pairs[0] = new Pair(0, 0);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            pairs[i] = new Pair(i, sum);
        }
        Arrays.sort(pairs, (a, b) -> a.sum - b.sum);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (min > pairs[i].sum - pairs[i - 1].sum) {
                if (pairs[i - 1].index < pairs[i].index) {
                    res[0] = pairs[i - 1].index;
                    res[1] = pairs[i].index - 1;
                } else {
                    res[0] = pairs[i].index;
                    res[1] = pairs[i - 1].index - 1;
                }
                min = pairs[i].sum - pairs[i - 1].sum;
            }
        }
        Arrays.sort(res);
        return res;
    }
}
