/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Map<DirectedGraphNode, Integer> degree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            degree.put(node, 0);
        }
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                degree.put(neighbor, degree.get(neighbor) + 1);
            }
        }
        DirectedGraphNode node = null;
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        while ((node = find0Degree(degree)) != null) {
            dfs(node, res, degree);
        }
        return res;
    }
    DirectedGraphNode find0Degree(Map<DirectedGraphNode, Integer> degree) {
        for (Map.Entry<DirectedGraphNode, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return null;
    }
    void dfs(DirectedGraphNode node, List<DirectedGraphNode> res, Map<DirectedGraphNode, Integer> degree) {
        res.add(node);
        degree.put(node, -1);
        for (DirectedGraphNode neighbor : node.neighbors) {
            degree.put(neighbor, degree.get(neighbor) - 1);
            if (degree.get(neighbor) == 0) {
                dfs(neighbor, res, degree);
            }
        }
    }
}
