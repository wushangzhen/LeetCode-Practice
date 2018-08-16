/**
 * Definition of ListNode
 * class ListNode {
 * public:
 *     int val;
 *     ListNode *next;
 *     ListNode(int val) {
 *         this->val = val;
 *         this->next = NULL;
 *     }
 * }
 */
struct compare {
    bool operator()(const ListNode* l, const ListNode* r) {
        return l->val > r->val;
    }
};
class Solution {
public:
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        // write your code here
        priority_queue<ListNode*, vector<ListNode*>, compare> q;
        for (auto list : lists) {
            if (list) {
                q.push(list);
            }
        }
        ListNode* dummy = new ListNode(-1);
        ListNode* tail = dummy;
        while (!q.empty()) {
            ListNode* head = q.top();
            q.pop();
            tail->next = head;
            tail = head;
            if (head->next) {
                q.push(head->next);
            }
        }
        return dummy->next;
    }
};
// O(nlogk)
