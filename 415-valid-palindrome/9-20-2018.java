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
        String str = s.toLowerCase();
        char[] sc = str.toCharArray();
        while (left < right) {
            while (left < right && sc[left] < 'a' || sc[left] > 'z') {
                if (sc[left] < '0' || sc[left] > '9') {
                    left++;
                } else {
                    break;
                }
            }
            while (left < right && sc[right] < 'a' || sc[right] > 'z') {
                if (sc[right] < '0' || sc[right] > '9') {
                    right--;
                } else {
                    break;
                }
            }
            if (sc[left] != sc[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
