/**
 * Definition for Undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */


class Solution {
public:
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
     UndirectedGraphNode* searchNode(vector<UndirectedGraphNode*>& graph,
                                    map<UndirectedGraphNode*, int>& values,
                                    UndirectedGraphNode* node,
                                    int target) {
        // write your code here
        unordered_set<UndirectedGraphNode*> hashSet;
        queue<UndirectedGraphNode*> que;
        que.push(node);
        while (!que.empty()) {
            UndirectedGraphNode* tempNode = que.front();
            que.pop();
            if (values[tempNode] == target) {
                return tempNode;
            }
            for (auto neighbor : tempNode->neighbors) {
                if (hashSet.find(neighbor) == hashSet.end()) {
                    if (values[neighbor] == target) {
                        return neighbor;
                    } else {
                        que.push(neighbor);
                        hashSet.insert(neighbor);
                    }
                }
            }
        }
        return NULL;
    }
};
