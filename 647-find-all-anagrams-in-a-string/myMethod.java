public class Solution {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        int[] hashMap = new int[256];
        char[] pc = p.toCharArray();
        char[] sc = s.toCharArray();
        if (pc.length > sc.length) {
            return result;
        }
        for (int i = 0; i < pc.length; i++) {
            hashMap[pc[i]]++;
        }
        int i = 0;
        int j = 0;
        while (j < sc.length) {
            while (j - i < pc.length) {
                hashMap[sc[j]]--;
                j++;
            }
            boolean flag = true;
            for (int k = 0; k < 256; k++) {
                if (hashMap[k] == -1 || hashMap[k] == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                result.add(i);
            }
            hashMap[sc[i]]++;
            i++;
        }
        return result;
    }
}
