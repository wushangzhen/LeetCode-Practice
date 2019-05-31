class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (nums.length == 0) {
            return res;
        }
        Arrays.fill(res, -1);
        Stack<Integer> stk = new Stack<>();
        int p = 0;
        stk.push(p++);
        for (; p < 2 * n; p++){
            while (!stk.isEmpty() && nums[stk.peek() % n] < nums[p % n]) {
                if (res[stk.peek() % n] == -1) {
                    res[stk.pop() % n] = nums[p % n];
                } else {
                    stk.pop();
                }
            }
            stk.push(p);
        }
        return res;
    }
}
