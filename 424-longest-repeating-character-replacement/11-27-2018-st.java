class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int[] memo = new int[26];
        char[] sc = s.toCharArray();
        int maxLength = 0;
        int maxCount = 0;
        while (right < n) {
            maxCount = Math.max(maxCount, ++memo[sc[right] - 'A']);
            right++;
            if (right - left - maxCount > k) {
                memo[sc[left] - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
        
    }
}
