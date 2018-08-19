class Solution {
public:
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    void sortColors2(vector<int> &colors, int k) {
        // write your code here
        if (colors.empty()) {
            return;
        }
        rainbowSort(colors, 0, colors.size() - 1, 1, k);
    }
    void rainbowSort(vector<int> &colors,
                int left,
                int right,
                int colorFrom,
                int colorTo) {
        if (colorTo == colorFrom) {
            return;
        }                
        if (left >= right) {
            return;
        }
        int colorMid = (colorFrom + colorTo) / 2;
        int l = left, r = right;
        while (l <= r) {
            while (l <= r && colors[l] <= colorMid) {
                l++;
            }
            while (l <= r && colors[r] > colorMid) {
                r--;
            }
            if (l <= r) {
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;
                l++;
                r--;
            }
        }
        rainbowSort(colors, left, r, colorFrom, colorMid);
        rainbowSort(colors, l, right, colorMid + 1, colorTo);
    }
};
