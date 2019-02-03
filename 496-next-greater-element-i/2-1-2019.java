class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> memo = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        for (int num : nums2) {
            while (!stk.isEmpty() && stk.peek() < num) {
                memo.put(stk.pop(), num);
            }
            stk.push(num);
        }
        int n = nums1.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = memo.getOrDefault(nums1[i], -1);
        } 
        return res;
    }
}
