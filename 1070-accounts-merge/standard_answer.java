public class Solution {
    /**
     * @param accounts: List[List[str]]
     * @return: return a List[List[str]]
     */
     Map<Integer, Integer> father;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // write your code here
        father = new HashMap<>();
        Map<String, List> emailToIds = getEmailsToIds(accounts);
        for (String email : emailToIds.keySet()) {
            List<Integer> ids = emailToIds.get(email);
            for (int i = 1; i < ids.size(); i++) {
                union(ids.get(i), ids.get(0));
            }
        }
        Map<Integer, Set<String>> idToEmailSet = getIdToEmailSet(accounts);
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (Integer id : idToEmailSet.keySet()) {
            List<String> sortedEmails = new ArrayList(idToEmailSet.get(id));
            Collections.sort(sortedEmails);
            sortedEmails.add(0, accounts.get(id).get(0));
            mergedAccounts.add(sortedEmails);
        }
        return mergedAccounts;
    }
    private Map<String, List> getEmailsToIds(List<List<String>> accounts) {
        Map<String, List> emailToIds = new HashMap<>();
        for (int user_id = 0; user_id < accounts.size(); user_id++) {
            List<String> account = accounts.get(user_id);
            for (int i = 1; i < account.size(); i++) {
                List<Integer> ids = emailToIds.getOrDefault(account.get(i), new ArrayList<Integer>());
                ids.add(user_id);
                emailToIds.put(account.get(i), ids);
            }
        }
        return emailToIds;
    }
   private Map<Integer, Set<String>> getIdToEmailSet(List<List<String>> accounts) {
        Map<Integer, Set<String>> idToEmailSet = new HashMap<>();
        for (int user_id  = 0; user_id < accounts.size(); user_id++) {
            int root_id = find(user_id);
            Set<String> emailSet = idToEmailSet.getOrDefault(root_id, new HashSet<String>());
            List<String> account = accounts.get(user_id);
            for (int i = 1; i < account.size(); i++) {
                emailSet.add(account.get(i));
            }
            idToEmailSet.put(root_id, emailSet);
        }
        return idToEmailSet;
    }
    
    private int find(int id) {
        List<Integer> path = new ArrayList<>();
        while (father.containsKey(id)) {
            path.add(id);
            id = father.get(id);
        }
        
        for (Integer i : path) {
            father.put(i, id);
        }
        
        return id;
    }
    
    private void union(int id1, int id2) {
        int root1 = find(id1);
        int root2 = find(id2);
        if (root1 != root2) {
            father.put(root1, root2);
        }
    }
}
