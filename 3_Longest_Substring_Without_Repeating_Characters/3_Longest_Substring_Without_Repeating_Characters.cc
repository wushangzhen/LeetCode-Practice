class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int characters[256] = {0};//保存出现的字符串
    int max_length = 0; // 最大子字符串长度
    int index_substring = 0;//最大子字符串的起始索引
    
    for(int i = 0; i < s.size(); i++){
        if (characters[s[i]] == 0 || characters[s[i]] < index_substring ) {
            
            //characters[s[i]] == 0 说明该字符还不存在
            //characters[s[i]] < index_substring 说明该字符已经出现过，但是不在现在的最大子字符串里面，比如 "tmmzuxt" 中的最大子字符串是 "mzuxt" ，但是 "mzuxt" 中的 t 在第一个就出现过了，但是 t 在当前的最大子字符串 “mzuxt” 没有出现过，所以也需要计数，加入最大子字符串长度
            max_length = max(max_length, i - index_substring + 1);
        }else{
            //该字符已经存在了，那么将更新 index_substring
            index_substring = characters[s[i]];
        }
        //给 characters[s[i]]  赋值 i+1 是为了作为最大子字符串的起始索引
        characters[s[i]] = i + 1;
    }
    return max_length;
    }
};


int lengthOfLongestSubstring2(string s) {
  int characters[256] = {0};
  int max_length = 0;
  int index_substring = 0;
  for (int i = 0; i < s.size(); i++) {
    if (characters[s[i]] == 0 || characters[s[i]] < index_substring) {
      max_length = max(max_length, i - index_substring + 1); 
      } else {
        index_substring = characters[s[i]];
      }
      characters[s[i]] = i + 1;
  }
    return max_length;
}
