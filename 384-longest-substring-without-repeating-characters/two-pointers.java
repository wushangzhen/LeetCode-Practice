public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        Set set = new HashSet();
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] sc = s.toCharArray();
        int result = Integer.MIN_VALUE; 
        int i = 0;
        int j = 0;
        while (j < sc.length) {
            if (!set.contains(sc[j])) {
                set.add(sc[j]);
                j++;
                result = Math.max(result, j - i);
            } else {
                while (j < sc.length && i < sc.length && sc[i] != sc[j]) {
                    set.remove(sc[i]);
                    i++;
                }
                set.remove(sc[i]);
                i++;
            }
        }
        return result;
    }
}
