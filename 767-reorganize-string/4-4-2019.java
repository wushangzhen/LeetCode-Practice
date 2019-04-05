class Solution {
    public String reorganizeString(String S) {
        StringBuilder sb = new StringBuilder();
        char[] sc = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : sc) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        Queue<Character> pq = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        for (char c : map.keySet()) {
            pq.add(c);
        }
        Queue<Character> remaining = new LinkedList<>();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            sb.append(c);
            map.put(c, map.get(c) - 1);
            remaining.add(c);
            if (remaining.size() == 2) {
                while (!remaining.isEmpty()) {
                    char t = remaining.poll();
                    if (map.get(t) == 0) {
                        continue;
                    }
                    pq.add(t);
                }
            }
        }
        String res = sb.toString();
        return res.length() == S.length() ? res : "";
    }
}
