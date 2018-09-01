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
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    vector<vector<int>> connectedSet(vector<UndirectedGraphNode*> nodes) {
        // write your code here
        vector<vector<int>> results;
        if (nodes.empty()) {
            return results;
        }
        unordered_set<UndirectedGraphNode*> hashSet;
        for (auto node : nodes) {
            if (hashSet.find(node) != hashSet.end()) {
                continue;
            }
            queue<UndirectedGraphNode*> que;
            que.push(node);
            vector<int> result;
            while (!que.empty()) {
                UndirectedGraphNode* top = que.front();
                que.pop();
                hashSet.insert(node);
                result.push_back(top->label);
                for (auto neighbor : top->neighbors) {
                    if (hashSet.find(neighbor) == hashSet.end()) {
                        hashSet.insert(neighbor); // this is the point
                        que.push(neighbor);
                    }
                }
            }
            sort(result.begin(), result.end());
            results.push_back(result);
        }
        return results;
    }
};
