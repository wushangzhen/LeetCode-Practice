/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(s);
        visited.add(s);
        int count = -1;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = q.poll();
                if (node == t) {
                    return count;
                }
                for (UndirectedGraphNode neighbor : node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        q.add(neighbor); 
                    }
                }
            }
        }
        return -1;
    }
}
