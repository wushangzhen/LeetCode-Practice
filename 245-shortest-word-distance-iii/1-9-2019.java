class Solution {
    Map<String, List<Integer>> map;
    public int shortestWordDistance(String[] words, String word1, String word2) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            List<Integer> list = map.get(word1);
            for (int i = 0; i < list.size() - 1; i++) {
                min = Math.min(list.get(i + 1) - list.get(i), min);
            }
            return min;
        }
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
