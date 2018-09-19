public class Solution {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        if (word == null || abbr == null) {
            return false;
        }
        char[] s = word.toCharArray();
        char[] t = abbr.toCharArray();
        int i = 0, j = 0;
        while (i < s.length && j < t.length) {
            if (Character.isDigit(t[j])) {
                if (t[j] == '0') {
                    return false;
                }
                int val = 0;
                while (j < t.length && Character.isDigit(t[j])) { // j < t.length is very important
                    val = val * 10 + t[j] - '0';
                    j++;
                }
                i += val;
            } else {
                if (s[i] != t[j]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == s.length && j == t.length;
    }
}
