class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i : barcodes) {
            memo.put(i, memo.getOrDefault(i, 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>((a, b)->(memo.get(b) - memo.get(a)));
        for (int i : memo.keySet()) {
            pq.add(i);
        }
        int[] ans = new int[barcodes.length];
        int k = 0;
        int count = 0;
        Queue<Integer> wait = new LinkedList<>();
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && count < 2) {
                int first = pq.poll();
                ans[k++] = first;
                memo.put(first, memo.get(first) - 1);
                wait.add(first);
                count++;
            }
            while (!wait.isEmpty() && wait.size() != 1) {
                if (memo.get(wait.peek()) > 0) {
                    pq.add(wait.poll());
                } else {
                    wait.poll();
                }
            }
            count = 0;
        }
        return ans;
    }
}
