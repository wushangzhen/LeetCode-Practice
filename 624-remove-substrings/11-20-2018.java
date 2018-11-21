public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    int min = Integer.MAX_VALUE;
    public int minLength(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            String str = q.poll();
            min = Math.min(str.length(), min);
            for (String d : dict) {
                int start = 0;
                while (str.indexOf(d, start) != -1) {
                    int index = str.indexOf(d, start);
                    String newStr = str.substring(0, index) + str.substring(index + d.length());
                    if (!set.contains(newStr)) {
                        q.add(newStr);
                        set.add(newStr);
                    }
                    start = index + d.length();
                }
            }
        }
        return min;
    }
}
