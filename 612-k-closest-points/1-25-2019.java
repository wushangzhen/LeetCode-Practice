class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || K < 1) {
            return new int[0][0];
        }
        Map<int[], Integer> memo = new HashMap<>();
        for (int[] point : points) {
            memo.put(point, computeDistanceSquare(point));
        }
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return memo.get(point2) - memo.get(point1);
            }
        });
        for (int[] point : points) {
            if (pq.size() < K) {
                pq.add(point);
            } else {
                int[] tempPoint = pq.peek();
                if (memo.get(tempPoint) > memo.get(point)) {
                    pq.poll();
                    pq.add(point);
                }
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
    private int computeDistanceSquare(int[] point) {
        return point[0] * point[0] + point[1] * point[1];  
    }
}
