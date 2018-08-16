bool isValid(string s) {
  stack<char> stk;
  for (auto c : s) {
    char k = stk.top();
    switch (c) {
      case '(' : {
        stk.push(c);
        break;
      }
      case '{' : {
        stk.push(c);
        break;
      }
      case '[' : {
        stk.push(c);
        break;
      }
      case ')' : {
        if (k == '(' || stk.empty()) {
          return false;
        } else {
          stk.pop();
        }
        break;
      }
      case ']' : {
        if (k != '[' || stk.empty()) {
          return false;
        } else {
          stk.pop();
        }
        break;
      }
      case '}' : {
        if (k != '{' || stk.empty()) {
          return false;
        } else {
          stk.pop();
        }
        break;
      }
      default: ; // pass
    }
  }
  return stk.empty();
}
