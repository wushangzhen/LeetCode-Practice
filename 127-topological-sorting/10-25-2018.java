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
        if (graph == null) {
            return new ArrayList<>();
        }
        Map<DirectedGraphNode, List<DirectedGraphNode>> map = new HashMap<>();
        Map<DirectedGraphNode, Integer> degree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            //map.putIfAbsent(node, new ArrayList<>());
            degree.putIfAbsent(node, 0);
            for (DirectedGraphNode neighbor : node.neighbors) {
            //    map.get(node).add(neighbor);
                degree.putIfAbsent(neighbor, 0);
                degree.put(neighbor, degree.get(neighbor) + 1);
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<>();
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        for (DirectedGraphNode node : degree.keySet()) {
            if (degree.get(node) == 0) {
                q.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode temp = q.poll();
            res.add(temp);
            for (DirectedGraphNode neighbor : temp.neighbors) {
                degree.put(neighbor, degree.get(neighbor) - 1);
                if (degree.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }
        }
        return res;
    }
}
