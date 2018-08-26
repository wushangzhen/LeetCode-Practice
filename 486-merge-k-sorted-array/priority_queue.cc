struct Element {
    int row;
    int col;
    int value;
    Element(int row, int col, int value) {
        this->row = row;
        this->col = col;
        this->value = value;
    }
};

struct Cmp {
    bool operator()(const Element& elem1, const Element& elem2) {
        return elem1.value > elem2.value;
    }
};

class Solution {
public:
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    vector<int> mergekSortedArrays(vector<vector<int>> &arrays) {
        // write your code here
        vector<int> result;
        if (arrays.size() == 0 || arrays[0].size() == 0) {
            return result;
        }
        priority_queue<Element, vector<Element>, Cmp> priQue;
        for (int i = 0; i != arrays.size(); ++i) {
            priQue.push(Element(i, 0, arrays[i][0]));
        }
        while (!priQue.empty()) {
            Element top = priQue.top();
            result.push_back(top.value);
            priQue.pop();
            if (top.col + 1 < arrays[top.row].size()) {
                priQue.push(Element(top.row, top.col + 1, arrays[top.row][top.col + 1]));
            }
        }
        return result;
        
    }
};
