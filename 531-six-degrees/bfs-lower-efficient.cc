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
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    int sixDegrees(vector<UndirectedGraphNode*> graph, UndirectedGraphNode* s, UndirectedGraphNode* t) {
        // write your code here
        if (graph.empty() || !s || !t) {
            return -1;
        }
        queue<UndirectedGraphNode*> que;
        que.push(s);
        int step = 0;
        unordered_set<int> hashSet;
        if (s->label == t->label) {
            return 0;
        }
        while (!que.empty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode* temp = que.front();
                que.pop();
                if (hashSet.find(temp->label) == hashSet.end()) {
                    hashSet.insert(temp->label);
                    for (auto neighbor : temp->neighbors) {
                        if (neighbor->label == t->label) {
                            return step + 1;
                        } else {
                            que.push(neighbor);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
        
    }
};
