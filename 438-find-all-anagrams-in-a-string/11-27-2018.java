class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        int left = 0;
        int right = 0;
        int[] memo = new int[26];
        for (char c : p.toCharArray()) {
            memo[c - 'a']++;
        }
        char[] sc = s.toCharArray();
        int n = sc.length;
        int m = p.length();
        int count = 0;
        while (right < n) {
            while (right < n && right - left < m) {
                if (memo[sc[right] - 'a'] > 0) {
                    count++;
                }
                memo[sc[right] - 'a']--;
                right++;
            }
            if (count == m) {
                res.add(left);
            }
            if (memo[sc[left] - 'a'] >= 0) {
                count--;
            }
            memo[sc[left] - 'a']++;
            left++;
        }
        return res;
    }
}
