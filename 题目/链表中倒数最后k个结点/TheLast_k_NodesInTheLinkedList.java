package TestCode;

import TestCode.PrintListFromHeadToTail.ListNode;

/*
 *  链表中倒数最后k个结点 
 *  输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
 *  如果该链表长度小于k，请返回一个长度为 0 的链表。 
 */
public class TheLast_k_NodesInTheLinkedList {
	 public ListNode FindKthToTail (ListNode pHead, int k) {
         // write code here
        ListNode frist;
        ListNode slow;
        int pos = 0;
  
        frist = pHead;
        slow = pHead;
  
        while (frist != null) {
            frist = frist.next;
            pos++;
            if (pos > k ) {
                slow = slow.next;
            }
        }
         if (pos < k ) {
             return null;
         }
        return slow;
    }
}
