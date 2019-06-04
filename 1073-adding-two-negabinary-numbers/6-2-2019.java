class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int carry = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        Stack<Integer> stk = new Stack<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += arr1[i--];
            }
            if (j >= 0) {
                carry += arr2[j--];
            }
            stk.push(carry & 1);
            carry = -(carry >> 1);
        }
        while (stk.size() > 1 && stk.peek() == 0) {
            stk.pop();
        }
        int[] res = new int[stk.size()];
        int size = stk.size();
        for (int k = 0; k < size; k++) {
            res[k] = stk.pop();
        }
        return res;
    }
}
