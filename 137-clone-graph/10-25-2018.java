/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode temp = q.poll();
            map.putIfAbsent(temp, new UndirectedGraphNode(temp.label));
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
