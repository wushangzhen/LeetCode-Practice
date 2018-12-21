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
        helper(0, s, new LinkedList<>(), res);
        return res;
    }
    void helper(int start, String s, List<String> list, List<List<String>> res) {
        if (start == s.length()) {
            if (list.size() == 1) {
                return;
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= 2 && start + i <= s.length(); i++) {
            list.add(s.substring(start, start + i));
            helper(start + i, s, list, res);
            list.remove(list.size() - 1);
        }
    }
}
