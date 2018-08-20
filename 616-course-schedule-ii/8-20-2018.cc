class Solution {
public:
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    vector<int> findOrder(int numCourses, vector<pair<int, int>> &prerequisites) {
        // write your code here
        vector<unordered_multiset<int>> edges(numCourses);
        vector<int> degree(numCourses);
        for (int i = 0; i < prerequisites.size(); i++) {
            edges[prerequisites[i].second].insert(prerequisites[i].first);
            degree[prerequisites[i].first]++;
        }
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> result;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            result.push_back(cur);
            int size = q.size();
            for (auto it = edges[cur].begin(); it != edges[cur].end(); it++) {
                degree[*it]--;
                if (degree[*it] == 0) {
                    q.push(*it);
                }
            }
        }
        if (result.size() == numCourses) {
            return result;
        } else {
            vector<int> vec;
            return vec;
        }
    }
};
