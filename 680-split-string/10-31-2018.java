public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        helper(s, 0, new LinkedList<>(), res);
        return res;
    }
    
    void helper(String s, int start, List<String> list, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= 2; i++) {
            if (start + i <= s.length()) {
                String str = s.substring(start, start + i);
                list.add(str);
                helper(s, start + i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
