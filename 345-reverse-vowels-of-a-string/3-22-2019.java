class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] sc = s.toCharArray();
        while (left < right) {
            if (!isValid(sc[left])) {
                left++;
                continue;
            }
            if (!isValid(sc[right])) {
                right--;
                continue;
            }
            if (left < right) {
                char temp = sc[left];
                sc[left] = sc[right];
                sc[right] = temp;
                left++;
                right--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : sc) {
            sb.append(c);
        }
        return sb.toString();
    }
    boolean isValid(char c) {
        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u'
            || c == 'A' || c == 'O' || c == 'E' || c == 'I' || c == 'U';
    }
class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] sc = s.toCharArray();
        while (left < right) {
            if (!isValid(sc[left])) {
                left++;
                continue;
            }
            if (!isValid(sc[right])) {
                right--;
                continue;
            }
            if (left < right) {
                char temp = sc[left];
                sc[left] = sc[right];
                sc[right] = temp;
                left++;
                right--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : sc) {
            sb.append(c);
        }
        return sb.toString();
    }
    boolean isValid(char c) {
        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u'
            || c == 'A' || c == 'O' || c == 'E' || c == 'I' || c == 'U';
    }
}}
