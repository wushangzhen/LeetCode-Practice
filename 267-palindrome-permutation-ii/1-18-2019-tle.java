class Solution {
    public List<String> generatePalindromes(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        int n = s.length();
        boolean[] visited = new boolean[n];
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        dfs("", String.valueOf(sc), visited, res);
        return new ArrayList<>(res);
    }
    void dfs(String str, String s, boolean[] visited, Set<String> res) {
        if (str.length() == s.length() && isPalindrome(str)) {
            res.add(str);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && s.charAt(i) == s.charAt(i - 1) && visited[i - 1] == false) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                dfs(str + s.charAt(i), s, visited, res);
                visited[i] = false;
            }
        }
    }
    boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
