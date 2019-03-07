class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        Stack<String> stk = new Stack<>();
        for (String op : ops) {
            if (op.equals("C")) {
                stk.pop();
            } else if (op.equals("D")) {
                int a = Integer.parseInt(stk.peek());
                stk.push(String.valueOf(a * 2));
            } else if (op.equals("+")) {
                int a = Integer.parseInt(stk.pop());
                int b = Integer.parseInt(stk.pop());
                stk.push(String.valueOf(b));
                stk.push(String.valueOf(a));
                stk.push(String.valueOf(a + b));
            } else {
                stk.push(op);
            }
        }
        int sum = 0;
        while (!stk.isEmpty()) {
            sum += Integer.parseInt(stk.pop());
        }
        return sum;
    }
}
