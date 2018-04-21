
//Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

bool hasCycle(ListNode *head) {
  if (head == NULL) {
    return false;
  } 
  ListNode* runner = head;
  ListNode* walker = head;
  while (runner->next->next != NULL && walker->next != NULL) {
    runner = runner->next->next;
    walker = walker->next;
    if (runner == walker) {
      return true;
    }
  }
  return false;
}
