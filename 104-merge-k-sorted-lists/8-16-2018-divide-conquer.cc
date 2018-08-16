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
        int len = lists.size();
        ListNode* result = mergeHelper(0, len - 1, lists);
        return result;
    }
    ListNode* mergeHelper(int start, int end, vector<ListNode*> &lists) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode* left = mergeHelper(start, mid, lists);
        ListNode* right = mergeHelper(mid + 1, end, lists);
        return merge2Lists(left, right);
    }
    ListNode* merge2Lists(ListNode* left, ListNode* right) {
        ListNode* dummy = new ListNode(-1);
        ListNode* tail = dummy;
        while (left != NULL && right != NULL) {
            if (left->val > right->val) {
                tail->next = right;
                right = right->next;
            } else {
                tail->next = left;
                left = left->next;
            }
            tail = tail->next;
        }
        if (left == NULL) {
            tail->next = right;
        } else {
            tail->next = left;
        }
        return dummy->next;
    }
    
};

