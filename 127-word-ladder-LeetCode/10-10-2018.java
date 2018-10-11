class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String str : wordList) {
            set.add(str);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        int count = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                char[] wc = word.toCharArray();
                for (int j = 0; j < wc.length; j++) {
                    char c = wc[j];
                    char[] temp = wc.clone();
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (c == k) {
                            continue;
                        }
                        temp[j] = k;
                        String s = String.valueOf(temp);
                        if (s.equals(endWord)) {
                            return count;
                        }
                        if (!visited.contains(s) && set.contains(s)) {
                            q.add(s);
                            visited.add(s);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
