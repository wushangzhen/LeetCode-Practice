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
    UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = -1;
        }
    }
    int find(int x) {
        if (father[x] < 0) {
            return x;
        }
        father[x] = find(father[x]);// should be father[x]
        return father[x];
    }
    void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) { // should be a != b
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
                    }
                    return a.city1.compareTo(b.city1);
                }
                return a.cost - b.cost;
            }
        });
        Map<String, Integer> hash = new HashMap<>();
        int n = connections.size();
        int count = 0;
        for (Connection connection : connections) {
            if (!hash.containsKey(connection.city1)) {
                hash.put(connection.city1, count++);
            }
            if (!hash.containsKey(connection.city2)) {
                hash.put(connection.city2, count++);
            }
        }
        UnionFind uf = new UnionFind(count);
        List<Connection> res = new ArrayList<>();
        for (Connection connection : connections) {
            String city1 = connection.city1;
            String city2 = connection.city2;
            int num1 = hash.get(city1);
            int num2 = hash.get(city2);
            int a = uf.find(num1);
            int b = uf.find(num2);
            if (a != b) {
                uf.union(a, b);
                count--;
                res.add(connection);
            }
        }
        return count == 1 ? res : new ArrayList<>();
    }
}
