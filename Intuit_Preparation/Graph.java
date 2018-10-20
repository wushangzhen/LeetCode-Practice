import java.util.*;
public class Graph {
    public static void find(int[][] inputs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] input : inputs) {
            map.putIfAbsent(input[1], new HashSet<>());
            map.putIfAbsent(input[0], new HashSet<>());
            map.get(input[1]).add(input[0]);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 0) {
                System.out.println("parent 0 :" + entry.getKey());
            }
            if (entry.getValue().size() == 1) {
                System.out.println("parent 1 :" + entry.getKey());
            }
        }
        Set<Integer> set1 = map.get(2);
        Set<Integer> set2 = map.get(3);
        Iterator<Integer> it = set1.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (set2.contains(i)) {
                System.out.println(true);
            }
        }
        Queue<Integer> pq = new LinkedList<>();
        pq.add(7);
        int last = 7;
        while (!pq.isEmpty()) {
            Integer i = pq.poll();
            last = i;
            if (map.containsKey(i)) {
                it = map.get(i).iterator();
                while (it.hasNext()) {
                    Integer x = it.next();
                    pq.add(x);
                }
            }
        }
        System.out.println(last);
        
    }
    public static void main(String[] args) {
        int[][] input = {{1,4}, {1,5}, {2,5}, {3,6}, {6,7}};
        Graph.find(input);
    }

}
