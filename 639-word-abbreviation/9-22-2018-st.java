public class Solution {
    /**
     * @param dict: an array of n distinct non-empty strings
     * @return: an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        // write your code here
        int len = dict.length;
        String[] ans = new String[len];
        int[] prefix = new int[len];
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < len; i++) {
            prefix[i] = 1;
            ans[i] = getAbbr(dict[i], 1);
            count.put(ans[i], count.getOrDefault(ans[i], 0) + 1);
        }
        while (true) {
            boolean unique = true;
            for (int i = 0; i < len; i++) {
                if (count.get(ans[i]) > 1) {
                    prefix[i]++;
                    ans[i] = getAbbr(dict[i], prefix[i]);
                    count.put(ans[i], count.getOrDefault(ans[i], 0) + 1);
                    unique = false;
                }
            }
            if (unique) {
                break;
            }
        }
        return ans;
    }
    String getAbbr(String s, int p) {
        if (p >= s.length() - 2) {
            return s;
        }
        String ans;
        ans = s.substring(0, p) + (s.length() - 1 - p) + s.charAt(s.length() - 1);
        return ans;
    }
}
