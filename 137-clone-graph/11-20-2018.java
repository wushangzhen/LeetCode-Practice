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
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, new UndirectedGraphNode(node.label));
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode temp = q.poll();
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                if (!map.containsKey(neighbor)) {
                    q.add(neighbor);
                }
                map.putIfAbsent(neighbor, new UndirectedGraphNode(neighbor.label));
                map.get(temp).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
