class Node {
    int city;
    int price;
    int stops;
    public Node(int city, int price, int stops) {
        this.city = city;
        this.price = price;
        this.stops = stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] flight : flights) {
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        pq.offer(new Node(src, 0, -1));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.city == dst) {
                return curr.price;
            }
            if (curr.stops == K) {
                continue;
            }
            for (Map.Entry<Integer, Integer> next : map.get(curr.city).entrySet()) {
                pq.offer(new Node(next.getKey(), curr.price + next.getValue(), curr.stops + 1));
            }
        }
        return -1;
    }
}
