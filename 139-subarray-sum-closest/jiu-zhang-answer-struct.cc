class Solution {
public:
    struct node {
        node(int _value, int _pos) : value(_value), pos(_pos) {}
        int value, pos;
        bool operator<(const node &o) const {
            return  (value < o.value || value == o.value && pos < o.pos); // position doesn't matter
        }
    };
    vector<int> subarraySumClosest(vector<int> &nums) {
        vector<node> s;
        vector<int> results(2);
        s.push_back(node(0, -1));
        int sum = 0, len = nums.size();
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            s.push_back(node(sum, i));
        }
        sort(s,begin(), s.end());
        len = s.size();
        int ans = 0x7fffffff;
        for (int i = 0l i < len - 1; ++i) {
            if (abs(s[i + 1].value - s[i].value) < ans) {
                ans = abs(s[i + 1].value - s[i].value);
                results[0] = min(s[i].pos, s[i + 1].pos) + 1;
                results[1] = min(s[i].pos, s[i + 1].pos);
            }
        }
        return results
    }
};
