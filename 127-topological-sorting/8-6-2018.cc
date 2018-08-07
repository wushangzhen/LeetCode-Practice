/**
 * Definition for Directed graph.
 * struct DirectedGraphNode {
 *     int label;
 *     vector<DirectedGraphNode *> neighbors;
 *     DirectedGraphNode(int x) : label(x) {};
 * };
 */

class Solution {
public:
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    vector<DirectedGraphNode*> topSort(vector<DirectedGraphNode*>& graph) {
        // write your code here
        vector<DirectedGraphNode*> res_vec;
        if (graph.empty()) {
            return res_vec;
        }
        unordered_map<DirectedGraphNode*, int> unMap;
        for (auto node : graph) {
            for (auto neighbor : node->neighbors) {
                if (unMap.find(neighbor) != unMap.end()) {
                    unMap[neighbor]++;
                } else {
                    unMap[neighbor] = 1;
                }
            }
        }
        queue<DirectedGraphNode*> que;
        for (auto node : graph) {
            if (unMap.find(node) == unMap.end()) {
                que.push(node);
                res_vec.push_back(node);
            }
        }
        while (!que.empty()) {
            auto node = que.front();
            que.pop();
            for (auto neighbor : node->neighbors) {
                unMap[neighbor]--;
                if (unMap[neighbor] == 0) {
                    que.push(neighbor);
                    res_vec.push_back(neighbor);
                }
            } 
        }
        return res_vec;
    }
};
