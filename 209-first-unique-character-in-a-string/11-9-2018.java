public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        if (str == null || str.length() == 0) {
            return 'x';
        } 
        char[] sc = str.toCharArray();
        Arrays.sort(sc);
        char res = 'x';
        for (int i = 0; i < sc.length;) {
            if (i + 1 < sc.length && sc[i] == sc[i + 1]) {
                char temp = sc[i];
                while (i < sc.length && sc[i] == temp) {
                    i++;
                }
            } else {
                res = sc[i];
                i++;
                return res;
            }
        }
        return res;
    }
}
