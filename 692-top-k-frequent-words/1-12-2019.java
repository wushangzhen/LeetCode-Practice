public class Solution {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        if (words == null || words.length == 0 || k <= 0) {
            return new String[0];
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
        for (String word : map.keySet()) {
            if (q.size() < k) {
                q.add(word);
            } else {
                q.add(word);
                q.poll();
            }
        }
        String[] res = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = q.poll();
        }
        return res;
    }
}
