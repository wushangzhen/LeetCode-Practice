class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); 
        // 先按照数值大小排序，同数值的按照，然后根据名次插入
        List<int[]> list = new LinkedList<>(); 
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][2]); 
    }
}
