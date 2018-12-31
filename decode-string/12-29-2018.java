class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        return dfs(s);
    }
    public String dfs(String s) {
        if (s.equals("")) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String times = "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                int left = i;
                count++;
                i++;
                while (count != 0) {
                    if (s.charAt(i) == '[') {
                        count++;
                    } else if (s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                i--;
                String str = dfs(s.substring(left + 1, i));
                int time = Integer.parseInt(times);
                while (time-- != 0) {
                    sb.append(str);
                }
                times = "";
            } else if ('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                times += s.charAt(i);  
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
