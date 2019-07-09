class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>();
        int prev = 0;
        int[] res = new int[n];
        for (String log : logs) {
            String[] strs = log.split(":");
            if (!stk.isEmpty()) {
                res[stk.peek()] += Integer.parseInt(strs[2]) - prev;
            }
            prev = Integer.parseInt(strs[2]);
            if (strs[1].equals("start")) {
                stk.push(Integer.parseInt(strs[0]));   
            } else {
                res[stk.pop()]++;
                prev++;
            }
        }
        return res;
    }
}
