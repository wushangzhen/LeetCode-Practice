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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    vector<ListNode*> rehashing(vector<ListNode*> hashTable) {
        // write your code here
        int small = hashTable.size();
        int large = small * 2;
        vector<ListNode*> result(large);
        ListNode* head;
        for (int i = 0; i < small; i++) {
            ListNode* temp = hashTable[i];
            while (temp != NULL) {
                int index = 0;
                if (temp->val >= 0) {
                    index = temp->val % large;
                } else {
                    index = (temp->val % large + large) % large;
                }
                ListNode* itemPush = new ListNode(temp->val);
                if (result[index] == NULL) {
                    result[index] = itemPush;
                } else {
                    push(result[index], temp);
                }
                temp = temp->next;
            }
        }
        return result;
    }
    void push(ListNode* node, ListNode* temp) {
        if (node->next == NULL) {
            node->next = new ListNode(temp->val);
        } else {
            push(node->next, temp);
        }
    }
};

