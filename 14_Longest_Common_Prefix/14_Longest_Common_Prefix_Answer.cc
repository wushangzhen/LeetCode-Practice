string longestCommonPrefix(vector<string>& strs) {
    if(strs.size()==0)
        return "";
        string ans=strs[0];
        int max=INT_MAX;
        for(auto& s:strs)
        {
            if(s.length()==0)
            return "";
            int i=0;
            for(i=0;i<ans.length()&&i<s.length();i++)
            {
                if(s[i]!=ans[i])
                break;
            }
            ans=ans.substr(0,i);
        }

        return ans;
    }
