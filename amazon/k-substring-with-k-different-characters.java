public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String s, int K) {
        // Write your code here
        if (s == null || s.length() == 0 || K < 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int n = s.length();
        if (K > n) {
            return 0;
        }
        int res = 0;
        int[] memo = new int[256];
        Set<String> hash = new HashSet<>();
        char[] sc = s.toCharArray();
        while (right < K) {
            if (memo[sc[right]] == 0) {
                count++;
            }
            memo[sc[right++]]--;
        }
        while (right < n) {
            if (count == K) {
                hash.add(s.substring(left, right));
            }
            if (memo[sc[right]] == 0) {
                count++;
            }
            memo[sc[right++]]--;
            if (memo[sc[left]] == -1) {
                count--;
            } 
            memo[sc[left++]]++;
        }
        if (count == K) {
            hash.add(s.substring(left, right));
        }
        return hash.size();
    }
}
