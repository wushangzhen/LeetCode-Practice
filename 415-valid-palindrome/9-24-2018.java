public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        char[] sc = s.toCharArray();
        while (left < right) {
            while (left < right && ('a' > sc[left] || sc[left] > 'z')) {
                if (sc[left] > '9' || sc[left] < '0') {
                    left++;
                } else {
                    break; // key point 
                }
            }
            while (left < right && ('a' > sc[right] || sc[right] > 'z')) {
                if (sc[right] > '9' || sc[right] < '0') {
                    right--;
                } else {
                    break;
                }
            }
            if (left <= right && sc[left] != sc[right]) {
                return false;
            } 
            left++;
            right--;
        }
        return true;
    }
}
