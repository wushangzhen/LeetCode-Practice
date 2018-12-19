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
        if (str.length() == 0) {
            res.add("");
            return res;
        }
        char[] sc = str.toCharArray();
        Arrays.sort(sc);
        dfs("", sc, new HashSet<>(), res);
        return res;
    }
    void dfs(String s, char[] sc, Set<Integer> visited, List<String> res) {
        if (s.length() == sc.length) {
            res.add(s);
            return;
        }
        for (int i = 0; i < sc.length; i++) {
            if (i != 0 && sc[i] == sc[i - 1] && !visited.contains(i - 1)) {
                continue;
            }
            if (!visited.contains(i)) {
                visited.add(i);
                dfs(s + sc[i], sc, visited, res);
                visited.remove(i);
            }
        }
    }
}
