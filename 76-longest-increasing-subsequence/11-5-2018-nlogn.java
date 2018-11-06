public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] minLast = new int[n + 1];
        minLast[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            minLast[i] = Integer.MAX_VALUE; 
        } 
        for (int i = 0; i < n; i++) {
            int index = find(nums[i], minLast);
            minLast[index] = nums[i];
        }
        for (int i = n; i >= 0; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        return 0;
    }
    
    int find(int target, int[] minLast) {
        int start = 0;
        int end = minLast.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (minLast[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (minLast[start] >= target) {
            return start;
        } else {
            return end;
        }
    }
}
