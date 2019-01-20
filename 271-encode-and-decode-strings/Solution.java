public class Codec {

    // Encodes a list of strings to a single string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] strs = s.split("\\/");
        List<String> res = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                len = Integer.parseInt(strs[i]);
            }
            if (i + 1 < strs.length) {
                res.add(strs[i + 1].substring(0, len));
                len = Integer.parseInt(strs[i + 1].substring(len));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.encode("");
    }
}



// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
