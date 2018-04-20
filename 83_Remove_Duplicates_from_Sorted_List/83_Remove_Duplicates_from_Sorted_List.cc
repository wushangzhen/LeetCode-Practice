#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* deleteDuplicates(ListNode* head) {
  ListNode* temp = head;
  while (temp) {
    while (temp->next && temp->val == temp->next->val) {
      temp->next = temp->next->next; 
    }
    temp = temp->next;
  }
  return head;
}
