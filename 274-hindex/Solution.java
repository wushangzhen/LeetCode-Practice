import java.util.*;        
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Comparator<Integer> cmp = new Comparator<Integer>() {
				public int compare(Integer i1, Integer i2) {
					return i2-i1;
				}
        };

        // Arrays.sort(citations, new Comparator<Integer>() {
        //     public int compare(Integer a, Integer b) {
        //         return b - a;
        //     }
        // });
            Arrays.sort(citations, cmp);
        for (int i = 0; i < citations.size(); i++) {
            if (i >= citations[i]) {
                return i;
            }
        }
        return citations.size();
    }
}
