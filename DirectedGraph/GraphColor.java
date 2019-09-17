import java.util.*;
class GraphColor {
    static class Graph {
        final int WHITE = 0, GRAY = 1, BLACK = 2;
        int n;
        List<List<Integer>> edges;
        public Graph(int n) {
            this.n = n;
            edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                edges.add(new ArrayList<>());
            }
        }
        public boolean hasCycle() {
            int[] colors = new int[n];
            Arrays.fill(colors, WHITE);
            for (int i = 0; i < n; i++) {
                if (hasCycleUtil(i, colors)) {
                    return true;
                }
            }
            return false;
        }
        public void addEdge(int s, int t) {
            edges.get(s).add(t);
        }
        public boolean hasCycleUtil(int x, int[] colors) {
            if (colors[x] == GRAY) {
                return true;
            }
            if (colors[x] == BLACK) {
                return false;
            }
            colors[x] = GRAY;
            for (int xx : edges.get(x)) {
                if (hasCycleUtil(xx, colors)) {
                    return true;
                } 
            }
            colors[x] = BLACK;
            return false;
        }
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
