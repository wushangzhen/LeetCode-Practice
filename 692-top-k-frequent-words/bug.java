class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k <= 0) {
            return res;
        }
        Queue<String> q = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String a, String b) {
                if (map.get(a) == map.get(b)) {
                    return b.compareTo(a);
                }
                return map.get(a) - map.get(b);
            }
        });
        Set<String> visited = new HashSet<>();
        for (String word : words) {
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
            if (q.size() < k && !visited.contains(word)) {
                q.add(word);
                visited.add(word);
                continue;
            }
            if (q.size() == k && !visited.contains(word)) {
                q.add(word);
                visited.add(word);
                System.out.println(word);
                visited.remove(q.poll());
            }
        }
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        Collections.sort(res, new Comparator<String>() {
            public int compare(String a, String b) {
                if (map.get(a) == map.get(b)) {
                    return a.compareTo(b);
                }
                return map.get(b) - map.get(a);
            }
        });
        return res;
    }
}
