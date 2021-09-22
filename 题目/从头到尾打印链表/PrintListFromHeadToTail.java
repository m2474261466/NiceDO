package TestCode;
/**
 * ��ͷ��β��ӡ����
 */
import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromHeadToTail {
	  public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	         Stack<ListNode> stack = new Stack<>();
	         ListNode temp = listNode;
	    while (temp != null) {
	        stack.push(temp);
	        temp = temp.next;
	    }
	    int size = stack.size();
	    ArrayList<Integer> list = new ArrayList<>(size);
	    for (int i = 0; i < size; i++) {
	        list.add(stack.pop().val);
	    }
	    return list;
	    }
	  
	  
	  
    ///���и���
	  
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
           this.val = val;
           }
    }
}
