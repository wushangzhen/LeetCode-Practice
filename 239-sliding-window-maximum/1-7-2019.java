class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return new int[0];
        }
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int right = 0;
        int n = nums.length;
        while (right <= n) {
            if (right >= k) {
                int index = dq.peekFirst();
                list.add(nums[index]);
                if (right - index == k) {
                    dq.pollFirst();    
                }
            }
            if (right < n) {
                pushItem(dq, right, nums);
            }
            right++;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    void pushItem(Deque<Integer> dq, int index, int[] nums) {
        while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[index]) {
            dq.pollLast();
        }
        dq.add(index);
    }
}
