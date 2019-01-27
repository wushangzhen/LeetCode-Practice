/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
 class UnionFind {
     int[] father;
     public UnionFind(int n) {
         father = new int[n];
         for (int i = 0; i < n; i++) {
             father[i] = -1;
         }
     }
     int find(int x) {
         if (father[x] < 0) {
             return x;
         }
         father[x] = find(father[x]);
         return father[x];
     }
     void union(int a, int b) {
         a = find(a);
         b = find(b);
         if (a != b) {
             if (father[a] < father[b]) {
                 father[a] += father[b];
                 father[b] = a;
             } else {
                 father[b] += father[a];
                 father[a] = b;
             }
         }
     }
 }
 
public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        if (connections == null || connections.size() == 0) {
            return connections;
        }
        Collections.sort(connections, new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if (a.cost == b.cost) {
                    if (a.city1.equals(b.city1)) {
                        return a.city2.compareTo(b.city2);
                    }
                    return a.city1.compareTo(b.city1);
                }
                return a.cost - b.cost;
            }
        });
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < connections.size(); i++) {
            if (!map.containsKey(connections.get(i).city1)) {
                map.put(connections.get(i).city1, count++);
            }
            if (!map.containsKey(connections.get(i).city2)) {
                map.put(connections.get(i).city2, count++);
            }
        }
        List<Connection> res = new ArrayList<>();
        UnionFind uf = new UnionFind(count);
        for (Connection item : connections) {
            if (uf.find(map.get(item.city1)) != uf.find(map.get(item.city2))) {
                res.add(item);
                count--;
                uf.union(map.get(item.city1), map.get(item.city2));
            }
        }
        return count == 1 ? res : new ArrayList<>();
    }
}
