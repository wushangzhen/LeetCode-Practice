class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String string = "";
        helper(n, n, result, string);
        return result;
    }
    void helper(int m1, int m2, List<String> result, String string) {
        if (m2 == 0) {
            result.add(string);
            return;
        }
        if (m1 > 0) {
            string += "(";
            helper(m1 - 1, m2, result, string);
            string = string.substring(0, string.length() - 1);
        }
        if (m2 > m1) {
            string += ")";
            helper(m1, m2 - 1, result, string);
            string = string.substring(0, string.length() - 1);
        }
    }
}
