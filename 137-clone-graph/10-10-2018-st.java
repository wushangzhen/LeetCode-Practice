/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        if (node == null) {
            return node;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        map.put(node.label, new UndirectedGraphNode(node.label));
        q.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode n = q.remove();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    q.add(neighbor);  
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return map.get(node.label);
    }
}
