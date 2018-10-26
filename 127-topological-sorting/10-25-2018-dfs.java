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
    int maxHeight = 0;
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph == null) {
            return null;
        }
        Map<DirectedGraphNode, Integer> degree = new HashMap<>();
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        for (DirectedGraphNode node : graph) {
            degree.putIfAbsent(node, 0);
            for (DirectedGraphNode neighbor : node.neighbors) {
                degree.putIfAbsent(neighbor, 0);
                degree.put(neighbor, degree.get(neighbor) + 1);
            }
        }
        List<DirectedGraphNode> list = new ArrayList<>();
        List<ArrayList<DirectedGraphNode>> bigRes = new ArrayList<>();
        for (DirectedGraphNode node : graph) {
            if (degree.get(node) == 0) {
                list.add(node);
            }
        }
        for (DirectedGraphNode node : list) {
            dfs(node, new ArrayList<>(), bigRes);
        }
        return bigRes.get(0);
    }
    void dfs(DirectedGraphNode node, ArrayList<DirectedGraphNode> list, List<ArrayList<DirectedGraphNode>> bigRes) {
        if (node.neighbors.size() == 0) {
            bigRes.add(new ArrayList<>(list));
            return;
        } 
        list.add(node);
        for (DirectedGraphNode neighbor : node.neighbors) {
             dfs(neighbor, list, bigRes);
        }
        //list.remove(list.size() - 1);
    }
}
