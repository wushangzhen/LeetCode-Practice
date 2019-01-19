class Solution {
    public List<String> generatePalindromes(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        int n = s.length();
        Map<Character, Integer> memo = new HashMap<>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < n; i++) {
            memo.putIfAbsent(sc[i], 0);
            memo.put(sc[i], memo.get(sc[i]) + 1);
        }
        int count = 0;
        String str = "";
        String odd = "";
        for (char c : memo.keySet()) {
            if (memo.get(c) % 2 == 1) {
                count++;
                odd += c;
            }
            for (int i = 0; i < memo.get(c) / 2; i++) {
                str += c;
            }
        }
        if (count > 1) {
            return new ArrayList<>();
        }
        int m = str.length();
        boolean[] visited = new boolean[m];
        sc = str.toCharArray();
        Arrays.sort(sc);
        dfs("", String.valueOf(sc), odd, visited, res);
        return new ArrayList<>(res);
    }
}
