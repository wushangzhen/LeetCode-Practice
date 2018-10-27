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
        dfs(s, list, res);
        return res;
    }
    void dfs(String s, List<String> list, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(s.substring(0, 1));
        dfs(s.substring(1), list, res);
        list.remove(list.size() - 1);
        if (s.length() > 1) {
            list.add(s.substring(0, 2));
            dfs(s.substring(2), list, res);
            list.remove(list.size() - 1);
        }
    }
}
