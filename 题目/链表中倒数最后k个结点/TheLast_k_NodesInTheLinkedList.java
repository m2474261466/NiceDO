package TestCode;

import TestCode.PrintListFromHeadToTail.ListNode;

/*
 *  �����е������k����� 
 *  ����һ���������һ������������������ԭ�����дӵ�����k�������β�ڵ��ȫ���ڵ㡣
 *  �����������С��k���뷵��һ������Ϊ 0 ������ 
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
