/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */


class Solution {
public:
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    UndirectedGraphNode* cloneGraph(UndirectedGraphNode* node) {
        // write your code here
        if (!node) {
            return NULL;
        }
        UndirectedGraphNode* p1 = node;
        UndirectedGraphNode* p2 = new UndirectedGraphNode(node->label);
        unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> map; // for used node
        queue<UndirectedGraphNode*> que;
        que.push(p1);
        map[node] = p2;
        while (!que.empty()) {
            p1 = que.front();
            p2 = map[p1];
            que.pop();
            for (int i = 0; i < p1->neighbors.size(); i++) {
                UndirectedGraphNode *nb = p1->neighbors[i];
                if (map.count(nb)) {
                    p2->neighbors.push_back(map[nb]);
                } else {
                    UndirectedGraphNode *temp = new UndirectedGraphNode(nb->label);
                    p2->neighbors.push_back(temp);
                    map[nb] = temp;
                    que.push(nb);
                }
            }
        }
        return map[node];
    }
};
