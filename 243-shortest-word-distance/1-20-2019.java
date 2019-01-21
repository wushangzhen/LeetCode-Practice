class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            min = Math.min(min, binarySearch(list2, list1.get(i)));
        }
        return min;
    }
    int binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (Math.abs(list.get(start) - target) < Math.abs(list.get(end) - target)) {
            return Math.abs(list.get(start) - target);
        } else {
            return Math.abs(list.get(end) - target);
        }
    }
}
