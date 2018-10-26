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
    public int father[];
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = -1;
        }
    }
    int find(int a) {
        if (father[a] < 0) {
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
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
        Collections.sort(connections, new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if (a.cost == b.cost) {
                    if (a.city1.equals(b.city1)) {
                        return a.city2.compareTo(b.city2);
                    } else {
                        return a.city1.compareTo(b.city1);
                    }
                } else {
                    return a.cost - b.cost;
                }
            }
        });
        int n = connections.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (Connection connection : connections) {
            if (!map.containsKey(connection.city1)) {
                map.put(connection.city1, count++);
            }
            if (!map.containsKey(connection.city2)) {
                map.put(connection.city2, count++);
            }
        }
        List<Connection> res = new ArrayList<>();
        for (Connection connection : connections) {
            int a = uf.find(map.get(connection.city1));
            int b = uf.find(map.get(connection.city2));
            if (a != b) {
                uf.union(a, b);
                res.add(connection);
            }
        }
        return res.size() == count - 1 ? res : new ArrayList<>();

    }
}
