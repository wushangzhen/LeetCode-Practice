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
            return node;
        }
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> hashSet = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        ArrayList<UndirectedGraphNode> result = new ArrayList<>();
        queue.add(node);
        hashSet.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.poll();
            result.add(temp);
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                if (!hashSet.contains(neighbor)) {
                    queue.add(neighbor);
                    hashSet.add(neighbor);
                }
            }
        }
        return result;
    } 
        
}
