#include <iostream>
#include <vector>
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

bool isPalindrome(ListNode* head) {
  ListNode* temp = head;
  std::vector<int> vec;
  while (temp) {
    vec.push_back(temp->val);
    temp = temp->next;
  }
  temp = head;
  for (int j = vec.size() - 1; j >= 0; j--) {
    if (vec[j] != temp->val) {
      return false;
    }
    temp = temp->next;
  }
  return true;
}

int main() {
  ListNode head(0);
  ListNode note1(1);
  ListNode note2(0);
  head.next = &note1;
  //note1.next = &note2;
  std::cout << isPalindrome(&head) << std::endl;


}
