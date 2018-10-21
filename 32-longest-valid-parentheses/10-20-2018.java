class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int start = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {    
                    start = i + 1;
                } else {
                    int index = stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - start + 1);
                    } else {
                       max = Math.max(max, i - stack.peek()); 
                    }
                    
                }
            }
        }
        return max;        
    }
}
