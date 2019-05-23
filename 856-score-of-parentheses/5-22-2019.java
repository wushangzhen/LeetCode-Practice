class Solution {
    public int scoreOfParentheses(String S) {
        if (S.equals("")) {
            return 0;
        }
        if (S.equals("()")) {
            return 1;
        }
        int count = 0;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                if (start + 1 != i) {
                    sum += 2 * scoreOfParentheses(S.substring(start + 1, i));
                } else {
                    sum += 1;
                }
                start = i + 1;
            }
        }
        return sum;
    }
}
