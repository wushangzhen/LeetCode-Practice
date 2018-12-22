class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - (k - 1)];
        int right = 0;
        Deque<Integer> dq = new LinkedList<>();
        while (right < nums.length) {
            if (right >= k && right - k == dq.peekFirst()) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }
            dq.addLast(right);
            if (right >= k - 1) {
                res[right - k + 1] = nums[dq.peekFirst()];
            }
            right++;
        }
        return res;
    }
}
