public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        if (s == null && t == null) {
            return true;
        }
        int n = s.length();
        int m = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        } else if (Math.abs(m - n) < 1) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        } else {
            if (n < m) {
                String temp = s;
                s = t;
                t = temp;
            }
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(0 , i) + s.substring(i + 1, s.length());
                if (temp.equals(t)) {
                    return true;
                }
            }
            return false;
        }
    }
}
