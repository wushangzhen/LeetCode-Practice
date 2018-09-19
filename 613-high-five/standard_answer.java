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
        Map<Integer, Double> answer = new HashMap<Integer, Double>();
        Map<Integer, PriorityQueue<Integer>> hash = new HashMap<Integer, PriorityQueue<Integer>>();
        for (Record r : results) {
            if (!hash.containsKey(r.id)) {
                hash.put(r.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> values = hash.get(r.id);
            if (values.size() < 5) {
                values.add(r.score);
            } else {
                int top = values.poll();
                values.add(Math.max(top, r.score));
            }
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hash.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += scores.poll();
            }
            double average = sum / 5;
            answer.put(id, average);
        }
        return answer;
        
    }
}
