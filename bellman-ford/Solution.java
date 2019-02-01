import java.util.*;
class Solution {
    public static void bellmanFord(int source, int[] arrFrom, int[] arrTo, int[] weight, int number) {
        int[] dist = new int[number];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0; 
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < arrFrom.length; j++) {
                if (dist[arrFrom[j]] != Integer.MAX_VALUE && dist[arrTo[j]] > dist[arrFrom[j]] + weight[j]) {
                dist[arrTo[j]] = dist[arrFrom[j]] + weight[j];    
                } 
                if (dist[arrTo[j]] != Integer.MAX_VALUE && dist[arrFrom[j]] > dist[arrTo[j]] + weight[j]) {
                dist[arrFrom[j]] = dist[arrTo[j]] + weight[j];    
                } 
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.printf("index: %d, dist[i]: %d\n", i, dist[i]);
        }
    }
    public static void main(String[] args) {
        int[] arrFrom = {0, 0, 1, 3, 1, 2};
        int[] arrTo = {1, 2, 3, 4, 4, 4};
        int[] weight = {1, 2, 2, 1, 1, 1};
        bellmanFord(0, arrFrom, arrTo, weight, 5);
    }
}
