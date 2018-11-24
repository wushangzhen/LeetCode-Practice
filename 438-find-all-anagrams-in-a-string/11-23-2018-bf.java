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
        for (int i = 0; i < s.length(); i++) {
            if (memo[s.charAt(i) - 'a'] == 0) {
                continue;
            }
            int[] temp = memo.clone();
            int j = 0;
            for (j = i; j < i + n && j < s.length(); j++) {
                if (temp[s.charAt(j) - 'a'] == 0) {
                    break;
                } else {
                    temp[s.charAt(j) - 'a']--; 
                }
            }
            if (j == i + n) {
                res.add(i);
            }
        }
        return res;
    }
}
