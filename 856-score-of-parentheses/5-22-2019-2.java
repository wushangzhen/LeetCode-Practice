class Solution {
    public int scoreOfParentheses(String S) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                sum += 1 << count;
            }
        }
        return sum;
    }
}
