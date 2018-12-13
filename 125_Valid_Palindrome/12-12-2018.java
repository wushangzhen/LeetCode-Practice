class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.trim();
        s = s.toLowerCase();
        int n = s.length();
        return helper(s);
    }
    boolean helper(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!check(s.charAt(left))) {
                left++;
                continue;
            }
            if (!check(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;  
    }
    boolean check(char c) {
        if (('0' <= c && c <= '9') || ('a' <= c && c <= 'z')) {
            return true;
        }
        return false;
    }
}
