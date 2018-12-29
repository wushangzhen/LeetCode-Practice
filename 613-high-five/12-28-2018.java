/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> hash = new HashMap<>();
        for (Record r : results) {
            if (!hash.containsKey(r.id)) {
                hash.put(r.id, new PriorityQueue<>());
            }
            int size = hash.get(r.id).size();
            if (size < 5) {
                hash.get(r.id).add(r.score);
            } else {
                if (hash.get(r.id).peek() < r.score) {
                    hash.get(r.id).poll();
                    hash.get(r.id).add(r.score);
                }
            }
        }
        for (Record r : results) {
            if (!res.containsKey(r.id)) {
                Queue<Integer> q = hash.get(r.id);
                double sum = 0;
                while (!q.isEmpty()) {
                    sum += q.poll();
                }
                res.put(r.id, sum / 5);
            }
        }
        return res;
    }
}
