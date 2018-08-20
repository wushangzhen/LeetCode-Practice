class Solution {
public:
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        // write your code here
        vector<unordered_multiset<int> > edges(numCourses); // unordered_multiset for repeat prerequisites happens.
        vector<int> degree(numCourses, 0);
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
        int node = 0;
        while (!q.empty()) {
            int cur = q.front();
            node++;
            q.pop();
            for (auto it = edges[cur].begin(); it != edges[cur].end(); it++) {
                degree[*it]--;
                if (degree[*it] == 0) {
                    q.push(*it);
                }
            }
        }
        return node == numCourses;
    }
};
