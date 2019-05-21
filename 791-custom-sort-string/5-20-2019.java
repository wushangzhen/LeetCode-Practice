class Solution {
    public String customSortString(String S, String T) {
        int[] memo = new int[26];
        for (char c : T.toCharArray()) {
            memo[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            for (int i = 0; i < memo[c - 'a']; i++) {
                sb.append(c);
            }
            memo[c - 'a'] = 0;
        }
        for (int i = 0; i < 26; i++) {
            while (memo[i] != 0) {
                sb.append((char)(i + 'a'));
                memo[i]--;
            }
        }
        return sb.toString();
    }
}
