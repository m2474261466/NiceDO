package TestCode;
//¶þ²æÊ÷µÄ¾µÏñ
import javax.swing.tree.TreeNode;

public class MirrorOfBinaryTree {
	public TreeNode Mirror (TreeNode pRoot) {
	    if(pRoot==null)
	        return pRoot;
	    TreeNode left=Mirror(pRoot.left);
	    TreeNode right=Mirror(pRoot.right);
	    pRoot.left=right;
	    pRoot.right=left;
	    return pRoot;
	}
	public class TreeNode {
		  int val = 0;
		   TreeNode left = null;
		   TreeNode right = null;
		    public TreeNode(int val) {
		 this.val = val;
		  }
	 }
}
