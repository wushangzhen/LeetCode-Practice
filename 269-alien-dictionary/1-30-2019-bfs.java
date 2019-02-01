class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> topo = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                topo.putIfAbsent(c, new HashSet<>());
            }
        }
        int n = words.length;
        for (int i = 0; i + 1 < n; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    if (!topo.get(c1).contains(c2)) {
                        topo.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Character key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.add(key);
                inDegree.put(key, -1);
            }
        }
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char next : topo.get(c)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    q.add(next);
                }
            }
        }
        if (sb.length() != inDegree.size()) {
            return "";
        }
        return sb.toString();
    }
}
