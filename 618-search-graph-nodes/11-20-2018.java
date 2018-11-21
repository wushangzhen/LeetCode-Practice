/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // write your code here
        if (values.get(node) == target) {
            return node;
        }
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode temp = q.poll();
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                if (values.get(neighbor) == target) {
                    return neighbor;
                }
                if (!visited.contains(neighbor)) {
                    q.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return null;
    }
}
