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
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode temp = q.poll();
            map.putIfAbsent(temp, new UndirectedGraphNode(temp.label));
            List<UndirectedGraphNode> list = temp.neighbors;
            for (UndirectedGraphNode item : list) {
                if (!map.containsKey(item)) {
                    map.put(item, new UndirectedGraphNode(item.label));
                    q.add(item);
                }
                map.get(temp).neighbors.add(map.get(item));
            }
        }
        return map.get(node);
    }
}
