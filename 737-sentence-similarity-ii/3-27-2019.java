class UnionFind {
    int[] father;
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            father[x] = y;
        }
    }
}

class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        if (words1.length != words2.length) {
            return false;
        }
        for (String word : words1) {
            if (!map.containsKey(word)) {
                map.put(word, count++);
            }
        }
        for (String word : words2) {
            if (!map.containsKey(word)) {
                map.put(word, count++);
            }
        }
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], count++);
            } 
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], count++);
            } 
        }
        UnionFind uf = new UnionFind(count);
        for (String[] pair : pairs) {
            int id1 = map.get(pair[0]);
            int id2 = map.get(pair[1]);
            uf.union(id1, id2);
        }
        int i = 0;
        for (; i < words1.length; i++) {
            int id1 = map.get(words1[i]);
            int id2 = map.get(words2[i]);
            if (uf.find(id1) != uf.find(id2)) {
                return false;
            }
        }
        return true;
    }
}
