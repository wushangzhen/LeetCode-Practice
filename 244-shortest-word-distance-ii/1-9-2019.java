class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        for (int num : map.get(word1)) {
            min = Math.min(find(num, word2), min);
        }
        return min;
    }
    int find(int target, String str) {
        List<Integer> list = map.get(str);
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (Math.abs(list.get(left) - target) < Math.abs(list.get(right) - target)) {
            return Math.abs(list.get(left) - target);
        } else {
            return Math.abs(list.get(right) - target);
        }
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
