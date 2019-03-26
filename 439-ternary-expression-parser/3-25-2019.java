class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return expression;
        }
        char[] exp = expression.toCharArray();
        return dfs(exp, 0, exp.length - 1) + "";
    }
    public char dfs(char[] c, int start, int end) {
        if (start == end) {
            return c[start];
        }
        int count = 0, i = start;
        for (; i <= end; i++) {
            if (c[i] == '?') {
                count++;
            } else if (c[i] == ':') {
                count--;
                if (count == 0) {
                    break;
                }
            }
        }
        return c[start] == 'T' ? dfs(c, start + 2, i - 1) : dfs(c, i + 1, end);
    }
}
