class Solution {
    public String reverseOnlyLetters(String S) {
        int left = 0;
        int right = S.length() - 1;
        char[] sc = S.toCharArray();
        while (left < right) {
            while (left < right && !isLetter(S.charAt(left))) {
                left++;
            }
            while (left < right && !isLetter(S.charAt(right))) {
                right--;
            }
            if (left < right) {
                char temp = sc[left];
                sc[left] = sc[right];
                sc[right] = temp;
                right--;
                left++;
            }
        }
        return String.valueOf(sc);
    }
    boolean isLetter(char c) {
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            return true;
        }
        return false;
    }
}
