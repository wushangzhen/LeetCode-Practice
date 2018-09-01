class Solution {
public:
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    bool validTree(int n, vector<vector<int>> &edges) {
        // write your code here
        if (n == 0) {
            return false;
        }
        if (edges.size() != n - 1) {
            return false;
        }
        unordered_map<int, unordered_set<int>> graph = initialize(n, edges);
        queue<int> que;
        unordered_set<int> hashSet;
        que.push(0);
        hashSet.insert(0);
        while (!que.empty()) {
            int temp = que.front();
            que.pop();
            for (auto neighbor : graph[temp]) {
                if (hashSet.find(neighbor) != hashSet.end()) {
                    continue;
                }
                que.push(neighbor);
                hashSet.insert(neighbor);
            }
        }
        return hashSet.size() == n;
    }
    unordered_map<int, unordered_set<int>> initialize(int n,
        vector<vector<int>> edges) {
        unordered_map<int, unordered_set<int>> graph;
        for (int i = 0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].insert(v);
            graph[v].insert(u);
        }
        return graph;
    }
};
