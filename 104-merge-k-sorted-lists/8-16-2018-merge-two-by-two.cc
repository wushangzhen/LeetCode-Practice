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
class Solution {
public:
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        // write your code here
        if (lists.empty()) {
            return NULL;
        }
        while (lists.size() != 1) {
            vector<ListNode*> newList;
            for (int i = 0; i < lists.size() - 1; i += 2) {
                newList.push_back(merge2Lists(lists[i], lists[i + 1]));
            }
            if (lists.size() % 2 != 0) {
                newList.push_back(lists[lists.size() - 1]); 
            }
            lists = newList;
        }
        return lists[0];
    }
private:
    ListNode* merge2Lists(ListNode* a, ListNode* b) {
        ListNode* dummy = new ListNode(-1);
        ListNode* tail = dummy;
        while (a != NULL && b != NULL) {
            if (a->val > b->val) {
                tail->next = b;
                b = b->next;
            } else {
                tail->next = a;
                a = a->next;
            }
            tail = tail->next;
        }
        if (a == NULL) {
            tail->next = b;
        } else {
            tail->next = a;
        }
        return dummy->next;
    }
};
