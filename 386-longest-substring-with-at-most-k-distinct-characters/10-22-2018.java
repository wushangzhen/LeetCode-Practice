public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        char[] sc = s.toCharArray();
        int left = 0;
        int right = 0;
        int n = sc.length;
        int[] arr = new int[256];
        int count = 0;
        int len = 0;
        while (right < n) {
            if (arr[sc[right]] == 0) {
                count++;
            }
            arr[sc[right]]--;
            right++;
            if (count <= k) {
               if (right - left > len) {
                   len = right - left;
               } 
            } else {
                while (++arr[sc[left]] != 0) {
                    left++;
                }
                left++;
                count--;
            }
        }
        return len;
    }
}
