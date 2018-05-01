bool isValid(string s) {
        stack<char> st;
        for(auto& i : s){
            if(!st.empty()){
                if(st.top() == '{' && i == '}')         st.pop();
                else if(st.top() == '[' && i == ']')    st.pop();
                else if(st.top() == '(' && i == ')')    st.pop();
                else                                    st.push(i);
            }
            else                                        st.push(i);
        }
        
        return st.empty();
    }

bool isValid(string s) {
        stack<char> paren;
        for (char& c : s) {
            switch (c) {
                case '(':
                case '{':
                case '[': paren.push(c); break;
                case ')': if (paren.empty() || paren.top()!='(') return false; else paren.pop(); break;
                case '}': if (paren.empty() || paren.top()!='{') return false; else paren.pop(); break;
                case ']': if (paren.empty() || paren.top()!='[') return false; else paren.pop(); break;
                default: ; // pass
            }
        }
        return paren.empty() ;
    }
