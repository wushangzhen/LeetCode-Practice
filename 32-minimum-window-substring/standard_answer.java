public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    private int[] letters = new int[256];
    public String minWindow(String source , String target) {
        // write your code here
        if (source == null || target == null || source.length() == 0 || target.length() == 0) {
            return "";
        }
        int i = 0;
        int j = 0;
        Arrays.fill(letters, 0);
        int length = Integer.MAX_VALUE;
        String result = "";
        char[] sc = source.toCharArray();
        char[] tc = target.toCharArray();
        for (char c : tc) {
            letters[c]++;
        }
        for (; i < sc.length; i++) {
            while (j < sc.length && !isFoundAll()) {
                letters[sc[j]]--;
                j++;
            }
            if (isFoundAll() && j - i < length) {
                length = j - i;
                result = source.substring(i, j);
            }
            letters[sc[i]]++;
        }
        return result;
    }
    boolean isFoundAll() {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
