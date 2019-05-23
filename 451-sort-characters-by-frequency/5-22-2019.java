class Solution {
    public String frequencySort(String s) {
        int[] memo = new int[256];
        for (char c : s.toCharArray()) {
            memo[c]++;
        }
        Queue<Character> pq = new PriorityQueue<>((a, b)->memo[b] - memo[a]);
        for (int i = 0; i < 256; i++) {
            if (memo[i] != 0) {
                pq.add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            while (memo[c] != 0) {
                sb.append(c);
                memo[c]--;
            }
        }
        return sb.toString();
    }
}
