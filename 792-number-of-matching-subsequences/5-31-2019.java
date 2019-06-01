class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, new LinkedList<>());
        }
        for (String w : words) {
            map.get(w.charAt(0)).add(w);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            Queue<String> q = map.get(c);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.poll();
                if (w.length() == 1) {
                    count++;
                } else {
                    map.get(w.charAt(1)).add(w.substring(1));
                }
            }
        }
        return count;
    }
}
