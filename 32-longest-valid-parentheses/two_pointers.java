class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        char[] sc = s.toCharArray();
        int max = 0;
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, right * 2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = sc.length - 1; i >= 0; i--) {
            if (sc[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, right * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }
}
