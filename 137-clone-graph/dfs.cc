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
        map<int, UndirectedGraphNode*> visitedTable;
        return clone(node, visitedTable);
    }
    UndirectedGraphNode* clone(UndirectedGraphNode* node, map<int, UndirectedGraphNode*> &visitedTable) {
         if (node == NULL) {
             return NULL;
         }
         if (visitedTable.find(node->label) != visitedTable.end()) {
             return visitedTable[node->label];
         }
         UndirectedGraphNode* newNode = new UndirectedGraphNode(node->label);
         visitedTable[newNode->label] = newNode;
         for (int i = 0; i < node->neighbors.size(); i++) {
             UndirectedGraphNode* neighbor = clone(node->neighbors[i], visitedTable);
             newNode->neighbors.push_back(neighbor);
         }
         return newNode;
    }
};
