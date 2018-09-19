public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int[] hashMapS = new int[256];
        int[] hashMapT = new int[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            hashMapS[sc[i]]++;
        }
        for (int i = 0; i < tc.length; i++) {
            hashMapT[tc[i]]++;
        }
        for (int i = 0; i < 256; i++) {
            if (hashMapT[i] != hashMapS[i]) {
                return false;
            }
        }
        return true;
    }
}
