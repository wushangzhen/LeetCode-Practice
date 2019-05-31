class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    count++;
                }
            }
            return count == word.length() || count == 1;
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    return false;
                }
            }
        }
        return true;
    }
}
