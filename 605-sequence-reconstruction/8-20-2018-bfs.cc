class Solution {
public:
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    bool sequenceReconstruction(vector<int> &org, vector<vector<int>> &seqs) {
        // write your code here
        unordered_map<int, vector<int>> graph;
        unordered_map<int, int> inDegree;
        for (auto seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (graph.find(seq[i]) == graph.end()) {
                    vector<int> vec;
                    graph[seq[i]] = vec;
                    inDegree[seq[i]] = 0;
                }
                if (i > 0) {
                    graph[seq[i - 1]].push_back(seq[i]);
                    inDegree[seq[i]]++;
                }
            }
        }
        if (org.size() != inDegree.size()) {
            return false;
        }
        queue<int> q;
        for (auto mem : inDegree) {
            if (mem.second == 0) {
                q.push(mem.first);
            }
        }
        int index = 0;
        while (q.size() == 1) {
            int cur = q.front();
            q.pop();
            if (org[index++] != cur) {
                return false;
            }
            for (int neighbor : graph[cur]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
            
        }
        return index == org.size();
    }
};
