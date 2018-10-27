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
        List<String> list = new LinkedList<>();
        dfs(s, 0, list, res);
        return res;
    }
    void dfs(String s, int start, List<String> list, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= 2 && start + i <= s.length(); i++) {
            list.add(s.substring(start, start + i));
            dfs(s, start + i, list, res);
            list.remove(list.size() - 1);
        }
    }
}
