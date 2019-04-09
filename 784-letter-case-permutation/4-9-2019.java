class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(0, S, "", res);
        return res;
    }
    void dfs(int start, String S, String str, List<String> res) {
        if (start == S.length()) {
            res.add(str);
            return;
        }
        char c = S.charAt(start);
        if (isLetter(c)) {
            dfs(start + 1, S, str + c, res);
            int dist = 'a' - 'A';
            if ('a' <= c && c <= 'z') {
                dfs(start + 1, S, str + (char)(c - dist), res);
            } else {
                dfs(start + 1, S, str + (char)(c + dist), res);
            }
        } else {
             dfs(start + 1, S, str + c, res);
        }
    }
    boolean isLetter(char c) {
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            return true;
        } 
        return false;
    }
}
