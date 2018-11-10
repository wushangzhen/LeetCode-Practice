public class Solution {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        // write your code here
        String[] arry = teststr.split(" ");
        char[] sc = pattern.toCharArray();
        Map<Character, String> hash1 = new HashMap<>();
        Map<String, Character> hash2 = new HashMap<>();
        if (arry.length != sc.length) {
            return false;
        }
        int n = arry.length;
        for (int i = 0; i < arry.length; i++) {
            if (!hash1.containsKey(sc[i]) && !hash2.containsKey(arry[i])) {
                hash1.put(sc[i], arry[i]);
                hash2.put(arry[i], sc[i]);
            } else if (!hash1.containsKey(sc[i]) && hash2.containsKey(arry[i])) {
                return false;
            } else if (hash1.containsKey(sc[i]) && !hash2.containsKey(arry[i])) {
                return false;
            } else if (!hash1.get(sc[i]).equals(arry[i])) {
                return false;
            }
        }
        return true;
    }
}
