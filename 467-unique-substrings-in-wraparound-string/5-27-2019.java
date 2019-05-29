class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] memo = new int[26];
        int n = p.length();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            if (i > 0 && (p.charAt(i) - 1 == p.charAt(i - 1) || (p.charAt(i) == 'a' && p.charAt(i - 1) == 'z'))) {
                count++;
            } else {
                count = 1;
            }
            if (count > memo[c - 'a']) {
                memo[c - 'a'] = count;
            }
        } 
        int res = 0;
        for (int m : memo) {
            res += m;
        }
        return res;
    }
}
