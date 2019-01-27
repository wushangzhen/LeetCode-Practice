public class Solution {
    /**
     * @param point: 
     * @param n: 
     * @return: nothing
     */
    public List<List<Integer>> nearestRestaurant(List<List<Integer>> points, int n) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (points == null || points.size() == 0 || n > points.size()) {
            return res;
        }
        Map<List<Integer>, Integer> memo = new HashMap<>();
        for (List<Integer> point : points) {
            memo.put(point, computeDistanceSquare(point));
        }
        Queue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            public int compare(List<Integer> point1, List<Integer> point2) {
                return memo.get(point2) - memo.get(point1);
            }
        });
        for (List<Integer> point : points) {
            if (pq.size() < n) {
                pq.add(point);
            } else {
                List<Integer> tempPoint = pq.peek();
                if (memo.get(tempPoint) > memo.get(point)) {
                    pq.poll();
                    pq.add(point);
                }
            }
        }
        int distance = memo.get(pq.peek());
       
        for (List<Integer> point : points) {
            if (memo.get(point) <= distance) {
                res.add(point);
            }
            if (res.size() == n) {
                break;
            }
        }
        return res;
    }
    private int computeDistanceSquare(List<Integer> point) {
        return point.get(0) * point.get(0) + point.get(1) * point.get(1);  
    }
}
