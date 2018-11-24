class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int[] memo = new int[26];
        for (int i = 0; i < p.length(); i++) {
            memo[p.charAt(i) - 'a']++;
        }
        int n = p.length();
        int right = 0;;
        int left = 0;
        int m = s.length();
        int count = n;
        char[] sc = s.toCharArray();
        while (right < m) {
            while (right < m && right - left != n) {
                if (memo[sc[right] - 'a'] > 0) {
                    count--;
                }
                memo[sc[right] - 'a']--;
                right++;
            }
            if (count == 0) {
                res.add(left);
            }
            if (memo[sc[left] - 'a'] >= 0) {
                count++;
            }
            memo[sc[left] - 'a']++;
            left++;
        }
        return res;
    }
}
