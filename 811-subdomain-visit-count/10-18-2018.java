class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] strArray = cpdomain.split(" ");
            int n =  Integer.parseInt(strArray[0]);
            String str = strArray[1];
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '.') {
                    String s = str.substring(i + 1);
                    map.put(s, map.getOrDefault(s, 0)+ n);
                }
            }
            map.put(str, map.getOrDefault(str, 0) + n);
        }
        for (String key : map.keySet()) {
            String res = map.get(key) + " " + key;
            result.add(res);
        }
        return result;
    }
}
