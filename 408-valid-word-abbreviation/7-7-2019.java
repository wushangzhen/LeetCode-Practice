class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() > word.length()) {
            return false;
        }
        int p1 = 0, p2 = 0;
        while (p2 < abbr.length()) {
            char c = abbr.charAt(p2);
            if (isLetter(c)) {
                if (p1 >= word.length() || word.charAt(p1) != c) {
                    return false;
                } else {
                    p1++;
                    p2++;
                }
            } else if (c >= '0' && c <= '9') {
                if (c == '0' && p2 + 1 < abbr.length() && !isLetter(abbr.charAt(p2 + 1))) {
                    return false;
                }
                int start = p2;
                while (p2 < abbr.length() && !isLetter(abbr.charAt(p2))) {
                    p2++;
                }
                int num = Integer.parseInt(abbr.substring(start, p2));
                int i = 0;
                for (; i < num && p1 < word.length(); i++) {
                    p1++;
                }
                if (i != num) {
                    return false;
                }
            }
        }
        return p1 == word.length() && p2 == abbr.length();
    }
    
    boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}
