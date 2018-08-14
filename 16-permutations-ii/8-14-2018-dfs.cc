class Solution {
public:
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    vector<vector<int>> permuteUnique(vector<int> &nums) {
        // write your code here
        vector<vector<int>> results;
        vector<int> vec;
        bool *visited_ptr = new bool[nums.size()];
        memset(visited_ptr, false, sizeof(visited_ptr));
        sort(nums.begin(), nums.end());
        dfs(results, vec, visited_ptr, nums);
        return results;
    }
private:
    void dfs(vector<vector<int>> &results, 
             vector<int> &vec, 
             bool* visited_ptr,
             vector<int> &nums) {
        if (vec.size() == nums.size()) {
            results.push_back(vec);
            return;
        } 
        for (int i = 0; i < nums.size(); i++) {
            if (visited_ptr[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited_ptr[i - 1]) {
                continue;
            }
            vec.push_back(nums[i]);
            visited_ptr[i] = true;
            dfs(results, vec, visited_ptr, nums);
            vec.pop_back();
            visited_ptr[i] = false;
        }
                 
    }
};
