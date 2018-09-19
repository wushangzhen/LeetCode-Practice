class Element {
    public int id;
    public int value;
    public int index;
    Element(int id, int index, int value) {
        this.id = id;
        this.index = index;
        this.value = value;
    }
}
class ElementComparator implements Comparator<Element> {
    public int compare(Element left, Element right) {
        return right.value - left.value;
    }
    
    
}
public class Solution {
    /**
     * @param arrays: a list of array
     * @param k: An integer
     * @return: an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        int n = arrays.length;
        Queue<Element> heap = new PriorityQueue<Element>(new ElementComparator());
        System.out.println(heap.size());
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == null || arrays[i].length == 0) {
                continue;
            }
            Arrays.sort(arrays[i]);
            Element newElem = new Element(i, arrays[i].length - 1, arrays[i][arrays[i].length - 1]);
            heap.offer(newElem);
        }
        System.out.println(heap.size());
        for (int i = 0; i < k - 1; i++) {
            Element elem = heap.poll();
            int index = elem.index;
            int id = elem.id;
            int value = elem.value;
            if (index - 1 >= 0) {
                heap.offer(new Element(id, index - 1, arrays[id][index - 1]));
            }
        }
        return heap.peek().value;
    }
}
