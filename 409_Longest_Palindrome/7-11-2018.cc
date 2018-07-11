#include <iostream>
#include <string>
#include <set>
using namespace std;
class Solution {
public:
    int longestPalindrome(string s) {
        set<char> set1;    
        for (auto i : s) {
            if (set1.find(i) != set1.end()) {
                set1.erase(i);
            } else {
                set1.insert(i);
            }
        }
        int remove = set1.size();
        if (remove != 0) {
            remove -= 1;
        }
        return s.length() - remove;
    }
};
int main() {

}
