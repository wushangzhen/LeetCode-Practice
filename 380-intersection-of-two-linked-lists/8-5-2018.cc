/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */


class Solution {
public:
    /*
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    ListNode * getIntersectionNode(ListNode * headA, ListNode * headB) {
        // write your code here
        if (headA == NULL || headB == NULL) {
            return NULL;
        }
        ListNode* node = headA;
        while (node->next != NULL) {
            node = node->next;
        }
        node->next = headB;
        ListNode* result = ListNodeCycle(headA);
        node->next = NULL;
        return result;
    }
private:
    ListNode* ListNodeCycle(ListNode* root) {
        if (root == NULL) {
            return NULL;
        }
        ListNode* slow = root;
        ListNode* fast = root->next;
        while (fast != NULL && fast->next != NULL) {
            if (fast == slow) {
                break;    
            }
            fast = fast->next->next;
            slow = slow->next;
        }
        slow = root;
        fast = fast->next;
        while (slow != fast) {
            slow = slow -> next;
            fast = fast -> next;
        }
        return fast;
    }
};
