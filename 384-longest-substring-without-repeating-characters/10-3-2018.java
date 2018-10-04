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
        char[] sc = s.toCharArray();
        int left = 0;
        int right = 0;
        int[] memo = new int[256]; 
        int max = 0;
        for (; right < sc.length; right++) {
            if (memo[sc[right]] == 1) {
                while (left < right && sc[left] != sc[right]) {
                    memo[sc[left]]--;
                    left++;
                }
                memo[sc[left]]--;
                left++;
            }
            memo[sc[right]]++;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
