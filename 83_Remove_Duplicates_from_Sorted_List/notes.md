this is list problem

When using iterative solution, we have to judge whether the temp is NULL
and judge if temp->next is NULL, if temp->val == temp->next->val
temp->next == temp->next->next
it doesn't matter whether temp->next->next is NULL or not. if it is the end of 
list, it's fine.

what we have to do is determine the if temp->next is NULL
