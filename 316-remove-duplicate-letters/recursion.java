class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] memo = new char[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            memo[s.charAt(i) - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;   
            }
            if (--memo[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
