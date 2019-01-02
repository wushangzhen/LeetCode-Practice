class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k <= 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
        }
        Queue<String> q = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String a, String b) {
                if (map.get(a) == map.get(b)) {
                    return b.compareTo(a);
                }
                return map.get(a) - map.get(b);
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (q.size() < k) {
                q.add(entry.getKey());
            } else {
                q.add(entry.getKey());
                q.poll();
            }
        }
        while (!q.isEmpty()) {
            res.add(0, q.poll());
        }
        return res;
    }
}
