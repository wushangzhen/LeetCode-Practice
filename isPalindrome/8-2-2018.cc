bool isPalindrome(string s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
        if (s[i] != s[j]) {
            return false;
        }
    }
    return true;
}
