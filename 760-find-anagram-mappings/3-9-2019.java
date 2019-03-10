class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int n = A.length;
        int[] res = new int[n];
        int t = 0;
        for (int a : A) {
            res[t++] = map.get(a); 
        }
        return res;
    }
}
