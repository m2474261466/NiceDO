package TestCode;

import TestCode.PrintListFromHeadToTail.ListNode;

/*
 ��ת���� 
*/
public class Reverselinkedlist {
	public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
         
        ListNode last = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
