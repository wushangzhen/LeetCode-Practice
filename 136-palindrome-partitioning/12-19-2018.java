class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        dfs(0, s, new LinkedList<>(), res);
        return res;
    }
    void dfs(int start, String s, List<String> list, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isValid(str)) {
                list.add(str);
                dfs(i, s, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
    boolean isValid(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
