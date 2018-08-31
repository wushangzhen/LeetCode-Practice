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
        map<UndirectedGraphNode*, int> visited;
        queue<UndirectedGraphNode*> q;
        q.push(s);
        visited[s] = 0;
        while (!q.empty()) {
            UndirectedGraphNode* temp = q.front();
            q.pop();
            if (temp == t) {
                break;
            }
            for (UndirectedGraphNode* neighbor : temp->neighbors) {
                if (visited.find(neighbor) == visited.end()) {
                    visited[neighbor] = visited[temp] + 1;
                    q.push(neighbor);
                }
            }
        }
        if (visited.find(t) == visited.end()) {
            return -1;
        } else {
            return visited[t];
        }
    }
};
