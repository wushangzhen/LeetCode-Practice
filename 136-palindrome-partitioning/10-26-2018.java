public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        dfs(s, 0, new LinkedList<>(), result);
        return result;
    }
    void dfs(String s, int start, List<String> list, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; start + i <= s.length(); i++) {
            if (isPalidrome(s.substring(start, start + i))) {
                list.add(s.substring(start, start + i));
                dfs(s, start + i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    boolean isPalidrome(String str) {
        if (str == "") {
            return true;
        }
        int left = 0;
        int right = 0;
        if (str.length() % 2 == 1) {
            left = str.length() / 2;
            right = str.length() / 2;
        } else {
            left = str.length() / 2 - 1;
            right = str.length() / 2;
        }
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return left == -1 && right == str.length();
    }
}
