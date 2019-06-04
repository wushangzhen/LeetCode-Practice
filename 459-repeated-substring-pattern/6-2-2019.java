class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0 && s.replaceAll(s.substring(0, i), "").equals("")) {
                return true;
            }
        }
        return false;
    }
}
