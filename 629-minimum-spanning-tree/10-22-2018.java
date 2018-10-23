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
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (father[a] < father[b]) {
            father[a] += father[b];
            father[b] = a;
        } else {
            father[b] += father[a];
            father[a] = b;
        }
    }
    
    public int find(int n) {
        if (father[n] < 0) {
            return n;
        }
        father[n] = find(father[n]);
        return father[n];
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
        Map<String, Integer> map = new HashMap<>();
        int n = 0;
        for (Connection con : connections) {
            if (!map.containsKey(con.city1)) {
                map.put(con.city1, n++);
            }
            if (!map.containsKey(con.city2)) {
                map.put(con.city2, n++);
            }
        }
        
        UnionFind uf = new UnionFind(connections.size() * 2);
        List<Connection> res = new ArrayList<>();
        for (Connection con : connections) {
            int a = map.get(con.city1);
            int b = map.get(con.city2);
            if (uf.find(a) != uf.find(b)) {
                res.add(con);
                uf.union(a, b);
            }
        }
        if (res.size() == n - 1) {
             return res;
        } else {
            return new ArrayList<>();
        }
       
    }
    
}
