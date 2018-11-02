public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (str == null) {
            return res;
        }
        char[] sc = str.toCharArray();
        Arrays.sort(sc);
        int n = sc.length;
        boolean visited[] = new boolean[n];
        dfs("", sc, res, visited);
        return res;
    }
    void dfs(String s, char[] sc, List<String> res, boolean[] visited) {
        if (s.length() == sc.length) {
            res.add(s);
            return;
        }
        for (int i = 0; i < sc.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i != 0 && sc[i] == sc[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            dfs(s + sc[i], sc, res, visited);
            visited[i] = false;
        }
    }
}
