public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums.length < k) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            sum += nums[right++];
            if (right < k) {
                continue;
            }
            if (right > k) {
                sum -= nums[left++];
            }
            list.add(sum);
            
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
