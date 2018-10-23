public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int[] memo = new int[256];
        char[] sc = s.toCharArray();
        int len = 0;
        while (right < sc.length) {
            if (memo[sc[right]] == 0) {
                memo[sc[right]]--;
                right++;
                len = Math.max(len, right - left);
                continue;
            }
            while (memo[sc[right]] == -1) {
                memo[sc[left]]++;
                left++;
            }
        }
        return len;
    }
}
