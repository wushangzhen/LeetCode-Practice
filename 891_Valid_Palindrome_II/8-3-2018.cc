class Solution {
public:
    /**
     * @param s: a string
     * @return: nothing
     */
    bool validPalindrome(string &s) {
        // Write your code here
        if (s.empty()) {
            return true;
        }
        int len = s.length();
        int left = 0, right = len - 1; 
        while (left < right) {
            if (s[left] == s[right]) {
                left++;
                right--;
            } else {
                return isPalindrome(left + 1, right, s) ||
                    isPalindrome(left, right - 1, s);
            }    
        }
        return true;
    }
private:
    bool isPalindrome(int left, int right, string s) {
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
};
