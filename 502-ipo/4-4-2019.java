class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Queue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        Queue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[]{Capital[i], Profits[i]});
        }
        int cap = W;
        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= cap) {
                pqPro.add(pqCap.poll());
            }
            if (!pqPro.isEmpty()) {
                int[] temp = pqPro.poll();
                cap += temp[1];
            }
        }
        return cap;
    }
}
