class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        if (s == null || s.length() == 0) {
            return longest;
        }
        for (String dd : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dd.length() && dd.charAt(i) == c) {
                    i++;
                }
            }
            if (i == dd.length() && dd.length() >= longest.length()) {
                if (dd.length() > longest.length() || dd.compareTo(longest) < 0) {
                    longest = dd;
                }
            }
        }
        return longest;
    }
}
