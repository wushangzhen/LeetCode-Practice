import java.util.*;
class Graph {
    List<List<Integer>> edges;
    int n;
    public Graph(int n) {
        this.n = n;
        this.edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
    }
    public void addEdge(int s, int t) {
        edges.get(s).add(t);
    }
    public boolean hasCycle() {
        boolean[] stk = new boolean[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (hasCycleUtil(i, stk, visited)) {
                return true;
            }
        }
        return false;
    }
    public boolean hasCycleUtil(int idx, boolean[] stk, boolean[] visited) {
        if (stk[idx]) {
            return true;
        }
        if (visited[idx]) {
            return false;
        }
        stk[idx] = true;
        visited[idx] = true;
        for (int next : edges.get(idx)) {
            if (hasCycleUtil(next, stk, visited)) {
                return true;
            }
        }
        stk[idx] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
//        g.addEdge(2, 0);
        g.addEdge(2, 3);
//        g.addEdge(3, 3);
        System.out.println(g.hasCycle());
    }
}
