import java.util.*;
class Solution {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();
    public Solution(int[] array) {
        for (int i : array) {
            stk1.push(i);
        }
    }
    public void sort() {
        while (!stk1.isEmpty()) {
            int temp = stk1.pop();
            if (stk2.isEmpty()) {
                stk2.push(temp);
                continue;
            }
            while (!stk2.isEmpty() && stk2.peek() < temp) {
               stk1.push(stk2.pop()); 
            }
            stk2.push(temp);
        }
        while (!stk2.isEmpty()) {
            System.out.println(stk2.pop());
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 8, 2, 6, 3};
        Solution s = new Solution(array);
        s.sort();
    }
}
