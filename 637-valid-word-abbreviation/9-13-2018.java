public class Solution {
    /**
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        if (abbr == null) {
            return false;
        }
        int i = 0;
        int j = 0;
        int wordLen = word.length();
        int abbrLen = abbr.length();
        char[] wToChar = word.toCharArray();
        char[] aToChar = abbr.toCharArray();
        while (i < wordLen && j < abbrLen) {
            if (wToChar[i] == aToChar[j]) {
                i++;
                j++;
                continue;
            } else if (Character.isDigit(aToChar[j])) {
                if (aToChar[j] == '0') {
                    return false;
                }
                int sum = 0;
                while (j < abbrLen && Character.isDigit(aToChar[j])) {
                    sum = sum * 10 + aToChar[j] - '0';
                    j++;
                }
                i += sum;
                if (i > wordLen) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return i == wordLen && j == abbrLen;
    }
}
